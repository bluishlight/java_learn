package java2;


import java1.Person;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) {
        Class clazz = Person.class;
        Field[] fields = clazz.getFields();

        for (Field field:fields){
            System.out.println(field); // 只展示public
        }
    }
}
