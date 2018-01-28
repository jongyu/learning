package com.zhongyu.controller

import com.zhongyu.bean.Example
import com.zhongyu.dao.ExampleDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by 鐘宇 on 01/08/2017.
 */
@RestController
class ExampleController {

    @Autowired
    private val exampleDao: ExampleDao? = null

    @GetMapping("example")
    fun list(): MutableList<Example> = exampleDao!!.findAll()

    @GetMapping("example/{id}")
    fun get(@PathVariable id: Int?): Example? {
        var exists = exampleDao!!.exists(id)
        return if (exists) {
            exampleDao!!.findOne(id)
        } else {
            null
        }
    }

    @PostMapping("example")
    fun save(name: String): Example {
        //JPA中需要新的對象
        var example = Example()
        example.name = name
        return exampleDao!!.save(example)
    }

    @PutMapping("example/{id}")
    fun update(@PathVariable id: Int, name: String): Example? {
        var exists = exampleDao!!.exists(id)
        return if (exists) {
            //JPA中需要一個新的對象，并傳入編號給它
            var example = Example()
            example.id = id
            example.name = name
            exampleDao!!.save(example)
        } else {
            null
        }
    }

    @DeleteMapping("example/{id}")
    fun delete(@PathVariable id: Int) {
        var exists = exampleDao!!.exists(id)
        return if (!exists) {
            //do something useful
        } else {
            exampleDao!!.delete(id)
        }
    }

}