package com.atguigu.spring5.bean;

public class Dept {
    private String dname;

    public void setDname(String name) {
        this.dname = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
