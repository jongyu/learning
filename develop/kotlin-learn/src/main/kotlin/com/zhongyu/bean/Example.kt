package com.zhongyu.bean

import javax.persistence.*

@Suppress("MemberVisibilityCanPrivate")
@Entity
@Table(name = "example_table")
class Example {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    var id: Int = 0
    var name: String = ""

    override fun toString(): String {
        return "Example(id=$id, name='$name')"
    }

}