package com.zhongyu.controller;

import com.zhongyu.bean.Example;
import com.zhongyu.commons.base.BaseController;
import com.zhongyu.commons.enums.ResultEnum;
import com.zhongyu.commons.result.Result;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZhongYu on 3/25/2017.
 */
@RestController
public class ExampleController extends BaseController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("example")
    public List<Example> exampleList() {
        List<Example> list = exampleService.listExample();
        return list;
    }

    @PostMapping("example")
    public String saveExample(Example example) {
        Integer result = exampleService.save(example);
        return result > 0 ? "success" : "failed";
    }

    @PutMapping("example")
    public String updateExample(Example example) {
        Integer result = exampleService.updateByPrimaryKey(example);
        return result > 0 ? "success" : "failed";
    }

    @DeleteMapping("example/{id}")
    public Result<Example> removeExample(@PathVariable("id") Integer id) {
        Integer result = exampleService.removeByPrimaryKey(id);
        return result > 0 ? success() : failed(ResultEnum.FAILED);
    }

}
