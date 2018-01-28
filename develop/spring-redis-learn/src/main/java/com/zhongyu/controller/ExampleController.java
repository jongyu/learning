package com.zhongyu.controller;

import com.zhongyu.bean.Example;
import com.zhongyu.common.bean.Pager;
import com.zhongyu.common.bean.ResultPager;
import com.zhongyu.common.util.PagerUtil;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhongYu on 4/18/2017.
 */
@Controller
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("list.html")
    public String index() {
        return "example/list";
    }

    @ResponseBody
    @GetMapping("pager")
    public ResultPager<Example> pager(@RequestParam(value = "offset", defaultValue = "1") Integer offset, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        Integer total = exampleService.countExample();
        Pager pager = PagerUtil.getPager(offset, limit, total);
        List<Example> examples = exampleService.examplePager(pager);
        return new ResultPager<>(pager.getTotalRecords(), examples);
    }

    @GetMapping("example/{id}")
    public String getEditExamplePage(Model model, @PathVariable("id") Integer id) {
        Example example = exampleService.getExample(id);
        model.addAttribute("example", example);
        return "example/edit";
    }

    @ResponseBody
    @PutMapping("example/{id}")
    public Map updateExample(Example example, @PathVariable("id") Integer id) {
        Map<String, String> map = new HashMap<>();
        map.put("success", "true");
        Integer result = exampleService.updateExample(example);
        if (result > 0) {
            map.put("success", "true");
            map.put("message", "Successful operation");
        }
        return map;
    }

    @ResponseBody
    @DeleteMapping("example/{id}")
    public Map removeExample(@PathVariable("id") Integer id) {
        Map<String, String> map = new HashMap<>();
        Integer result = exampleService.removeExample(id);
        if (result > 0) {
            map.put("success", "true");
            map.put("message", "successfully deleted");
        }
        return map;
    }

}
