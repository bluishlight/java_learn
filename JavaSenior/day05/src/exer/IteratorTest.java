package exer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class IteratorTest {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add(1);
        list.add("tom");
        list.add(123);
        list.add(new Product("huawei",1000));

//        System.out.println(list);
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            Object obj = iterator.next();
//            System.out.println(obj);
//            if(obj.equals("tom")){
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
        // 增强for循环 内部是迭代器 类似js 的forEach
//        for(Object obj:list){
//            System.out.println(obj);
//        }
        int[] arr = {1,2,3,4,5};
        for(int obj:arr){
            System.out.println(obj);
            // 更改obj 不会修改原数据
        }


    }
}

class Product{
    private String name;
    private  int price;
    public Product(String name, int price){
        this.name  = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}