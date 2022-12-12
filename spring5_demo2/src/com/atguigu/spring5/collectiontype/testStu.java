package com.atguigu.spring5.collectiontype;

import com.atguigu.spring5.factoryBean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testStu {
    @Test
    public void testOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = (Stu) context.getBean("stu", Stu.class);
        stu.display();
    }

    @Test
    public void testTwo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Stu stu = (Stu) context.getBean("stu", Stu.class);
        stu.displayCourseList();
    }

    @Test
    public void testThree(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book stu = (Book) context.getBean("book", Book.class);
        stu.display();
    }
    @Test
    public void testFour(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
//        MyBean myBean = (MyBean) context.getBean("MyBean", BoMyBeanok.class);
        Course course = context.getBean("MyBean",Course.class);
        System.out.println(course);
    }
}

