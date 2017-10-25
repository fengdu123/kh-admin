package com.kh.admin.model;

import java.io.Serializable;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 16:15 2017/6/28
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -3562550857760039655L;
    private String  name ;
    private int age ;
    public Person(){}
    public Person(String name, int age) {
        super ();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name ;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age ;
    }
    public void setAge( int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" +  name +  ", age=" +  age +  "]" ;
    }
}

