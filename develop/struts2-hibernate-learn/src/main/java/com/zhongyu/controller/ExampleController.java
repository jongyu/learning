package com.zhongyu.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zhongyu.bean.Example;
import com.zhongyu.service.ExampleService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@ParentPackage("json-default")
@Namespace("/example")
public class ExampleController extends ActionSupport {

    @Autowired
    private ExampleService exampleService;

    @Getter
    @Setter
    private Example example;

    @Action(value = "index", results = {@Result(name = "example", location = "example.jsp")})
    public String index() {
        return "example";
    }

    @Action(value = "get", results = {@Result(name = "get", type = "json")})
    public String get(){
        example = exampleService.get(example.getId());
        return "get";
    }

    @Action(value = "save", results = {@Result(name = "save", type = "json")})
    public String save() {
        exampleService.save(example);
        return "save";
    }

    @Action(value = "update", results = {@Result(name = "update", type = "json")})
    public String update() {
        exampleService.update(example);
        return "update";
    }

    @Action(value = "delete", results = {@Result(name = "delete", type = "json")})
    public String delete() {
        exampleService.delete(example);
        return "delete";
    }

}
