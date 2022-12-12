package exer;

import java.util.*;
/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *

 */
public class CollectionTest {
    public static void main(String[] args) {

        Collection collection = new ArrayList();
        collection.add("hhaha");
        collection.add(132);
        collection.add(true);

        System.out.println(collection);
        // 利用equals比较字符串
        System.out.println( collection.contains(new String("hhaha")));
        Collection coll1 = Arrays.asList(132,"hhaha");
        collection.addAll(coll1);
        System.out.println("***"+collection);
        System.out.println(collection.containsAll(coll1));
        collection.remove(132);
        System.out.println(collection);
        collection.removeAll(coll1); // 移除共有元素
        System.out.println(collection);
        // retainAll交集 equals 全部比较 注意这个是有序的比较
        List list = Arrays.asList(new int[]{1,2,3}); // 作为int 数组传递的
        System.out.println(list);
        System.out.println(list.size());
        List list2 = Arrays.asList(new Integer[]{1,2,3}); // 作为1,2,3 传递的
        System.out.println(list2);
        System.out.println(list2.size());
        // 集合 到数组 toArray
        //遍历
        Iterator iterator = list2.iterator();
        System.out.println(iterator.next());// 法1 不适用
        // fa2 coll.size for循环

        System.out.println("法 3");
        while(iterator.hasNext()){

            Object obj = iterator.next();
            System.out.println(obj);
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        System.out.println(coll1 instanceof  Collection);
    }
}
