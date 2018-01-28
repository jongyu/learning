package com.zhongyu.controller;

import com.alibaba.fastjson.JSON;
import com.zhongyu.bean.Example;
import com.zhongyu.service.ExampleService;
import com.zhongyu.service.impl.ExampleServiceImpl;
import com.zhongyu.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@WebServlet("/example/*")
public class ExampleController extends HttpServlet {

    private ExampleService exampleService;

    public ExampleController() {
        exampleService = new ExampleServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = WebUtil.getURI(request);
        if (method.equals("save")) {
            save(request, response);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Example example = new Example();
        example.setName(name);
        example.setAge(Integer.parseInt(age));
        boolean result = exampleService.save(example);
        Map<String, String> message = new HashMap<>();
        if (result == true) {
            message.put("message", "添加成功!");
        } else {
            message.put("message", "添加失败!");
        }
        writer.println(JSON.toJSONString(message));
    }
}
