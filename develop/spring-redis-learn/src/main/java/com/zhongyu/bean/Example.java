package com.zhongyu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhongYu on 4/18/2017.
 */
public class Example implements Serializable {

    private static final long serialVersionUID = -1403019425435176375L;

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Date birthday;

    public Example() {

    }

    public Example(Integer id, String name, Integer age, String sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
