package com.zhongyu.controller

import com.zhongyu.bean.Example
import com.zhongyu.dao.ExampleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * Created by ZhongYu on 06/08/2017.
 */
@RestController
@RequestMapping("examples")
class ExampleController {

    @Autowired
    ExampleRepository exampleRepository

    @GetMapping("example/{id}")
    def findById(@PathVariable Integer id) {
        return exampleRepository.findOne(id)
    }

    @PostMapping("example")
    def saveExample(Example example){
        exampleRepository.save(example)
    }

    @PutMapping("example")
    def updateExample(@RequestBody Example example){
        exampleRepository.save(example)
    }

    @DeleteMapping("example/{id}")
    def removeExample(@PathVariable Integer id){
        exampleRepository.delete(id)
    }

}
