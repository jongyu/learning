package com.zhongyu.util

import com.google.common.util.concurrent.AtomicLongMap
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by ZhongYu on 18/08/2017.
 */
@Component
class ExecuteScript {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteScript.class)

    static final ThreadNumber = 4
    static final AtomicLongMap cmdCounter = AtomicLongMap.create()
    static final ExecutorService executorService = Executors.newFixedThreadPool(ThreadNumber);

    static void execute(final String cmd, final boolean wait = true) {
        if (cmdCounter.get(cmd) > 0) {
            logger.info('Skip Command {}, it\'s now running', cmd)
            if (!cmd.contains('AutoExportCommentStream')) {
                final cmds = cmdCounter.asMap().collect { c, v -> v > 0 ? "$v\t$c" : null }.grep()
                logger.info("Skip Command:$cmd\\n\\nCurrently Running:\\n${cmds.join('\\n')}")
            }
            return
        }
        final runnable = new Runnable() {
            void run() {
                try {
                    logger.info("\n\tEXEC ${cmd} Started")
                    final execute = cmd.execute()

                    def exitValue = 0
                    if (wait) exitValue = execute.waitFor()

                    final output = execute.text
                    if (exitValue != 0) {
                        logger.info("Schedule job failed:$cmd\\n\\nexitValue=$exitValue\\noutput=$output")
                    }
                    logger.info("\n\tEXEC ${cmd} Completed\n\t-------------------------------------------\n\t${output.split('\n').join('\n\t')}\n\t-------------------------------------------\n")
                } catch (e) {
                    logger.info("Exception ${e.class.simpleName}:${e.message} captured", e)
                } finally {
                    cmdCounter.decrementAndGet(cmd)
                }
            }
        }
        cmdCounter.incrementAndGet(cmd)
        executorService.execute(runnable)
    }

}
