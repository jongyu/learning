package com.zhongyu.bean

import javax.persistence.*

/**
 * Created by ZhongYu on 06/08/2017.
 */
@Entity
@Table(name = "example")
class Example implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String name

    Integer age, sex

    Date birthday

    String city, address

}
