#!/usr/bin/env bash
time=$(date "+%Y-%m-%d")
application=jenkins.war

function start(){
    echo "starting ...."
    java -Xmx4G -jar ~/jenkins.war --httpPort=80 $2 >> ~/logs/${application}-${time}.log 2>&1 &
    echo "star completion...."
}

function stop(){
    echo "shutting down ...."
    pkill -f ${application}
    sleep 8
}

function restart(){
    ps -ef | grep ${application}
    stop
    echo "starting ...."
    java -Xmx4G -jar ~/jenkins.war --httpPort=80 $2 >> ~/logs/${application}-${time}.log 2>&1 &
    echo "started ...."
    ps -ef | grep ${application}
}

case "$1" in
    "start")
      start $@
      exit 0
    ;;
    "stop")
      stop
      exit 0
    ;;
    "restart")
       restart $@
       exit 0
    ;;
    *)
       echo "usage： $0 {start|stop|restart} [now]"
       exit 1
    ;;
esac
