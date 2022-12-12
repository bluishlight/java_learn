package com.atguigu.exer;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
    // 比较器 重要
    /*
    * 比较对象
    * Comparable
    * */
    public static void main(String[] args) {
        //
        Product p1 = new Product("HUAWEI",1000);
        Product p2 = new Product("XIAOMI",700);
        Product p3 = new Product("ALIEN",2000);
        Product[] arr = new Product[]{p1, p2, p3};
//      Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -(o1.price - o2.price);
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(System.getProperty("user.name"));
    }

}
class Product implements Comparable{
    public String name;
    public int price;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p=null;
        if(o instanceof Product){
            p = (Product) o;
        }
        return this.price - p.price;
    }
}