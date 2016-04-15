package com.example.houlinjiang.myapplicationtest.sqlite;

/**
 * Created by houlin.jiang on 2016/4/14.
 */
public class Person {
    public String name = "";
    public int age ;

    public Person(String name, boolean sex, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this.name = "default";
        this.age = 18;
    }
}
