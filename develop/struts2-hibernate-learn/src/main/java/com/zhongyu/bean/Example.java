package com.zhongyu.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@Entity
@Table(name = "example")
@Data
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

}
