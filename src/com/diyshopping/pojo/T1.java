package com.diyshopping.pojo;

public class T1 {
    private  int age;
    private String name;
    private String dept;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "T1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
