package com.atguigu.spring5.collectiontype;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    // 数组类型属性
    private String[] courses;
    // list
    private List<String> list;
    //set
    private Set<String> set;
    private Map<String,String> maps;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    private List<Course> courseList;

    public void displayCourseList(){
        System.out.println(courseList);
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }



    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void display(){
//        courses.forEach(System.out::println);
        System.out.println(courses[0]);
        System.out.println(list);
        System.out.println(maps);
        System.out.println(set);
    }
}
