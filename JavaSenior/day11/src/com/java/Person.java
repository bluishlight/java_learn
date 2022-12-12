package com.java;

public class Person {
    public int age;
    private String name;


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


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person( String name, int age) {
        this.age = age;
        this.name = name;
    }
    public   void show(){
        System.out.println("一个人");
    }
    private void showNation(){
        System.out.println("国籍是");
    }
}
