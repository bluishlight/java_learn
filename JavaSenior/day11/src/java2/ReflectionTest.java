package java2;

import java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
* 重点 调用运行时类中指定的结构 属性 方法 构造器
* */
public class ReflectionTest {
    @Test
    public void TestField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;
        //
        System.out.println(clazz.getField("weight"));
        Person p = (Person) clazz.newInstance();


        //获取指定的属性：要求运行时类中属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值

        set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
         */

        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
        System.out.println(p.id);

    }

    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show",String.class);
        show.setAccessible(true);
        show.invoke(person,"CHN");
//        person.show();
        Method show2 = clazz.getDeclaredMethod("showDesc");
        show2.setAccessible(true);
        Object returnVal = show2.invoke(Person.class);// 静态 注意这里Person.class不是必须的
        System.out.println(returnVal);
    }

}
