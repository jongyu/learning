package com.zhongyu

import com.zhongyu.bean.Example
import com.zhongyu.dao.ExampleRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import java.text.SimpleDateFormat

@RunWith(SpringRunner)
@SpringBootTest
class ApplicationTests {

    @Autowired
    ExampleRepository exampleRepository

    @Test
    void contextLoads() {

    }

    @Test
    void testSave() {
        Example example = new Example()
        example.name = "zhangpen"
        example.age = 19
        example.sex = 1
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd")
        example.birthday = format.parse("1997-12-26")
        example.city = "Shanghai"
        example.address = "静安区天目西路街道"
        Serializable result = exampleRepository.save(example)
        println result.name
    }

    @Test
    void testGet(){
        Example example = exampleRepository.findOne(1)
        println(example.name)
    }

    @Test
    void testUpdate(){
        Example example = new Example()
        example.id = 1
        example.name = "wanggen"
        example.age = 20
        example.sex = 1
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd")
        example.birthday = format.parse("1998-12-26")
        example.city = "Shanghai"
        example.address = "静安区"
        exampleRepository.save(example)
    }

    @Test
    void testRemove(){
        exampleRepository.delete(1)
    }

}
