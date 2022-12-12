package review;

import java.util.Arrays;
import java.util.Comparator;

public class CompareReview {
    public static void main(String[] args) {
        Product p1 = new Product("huawei",1000);
        Product p2 = new Product("xiaomi",900);
        Product p3 = new Product("dell",950);
        Product p4 = new Product("aline",5000);
        Product[] arr = new Product[]{p1,p2,p3,p4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.price - o1.price;
                    }
                }
        );
        System.out.println(Arrays.toString(arr));
    }
}

class Product implements Comparable{
    public String name;
    public int price;
    public Product(String name, int price){
        this.name=name;
        this.price=price;
    }

    @Override
    public int compareTo(Object o) {
        Product p = (Product) o;
        return this.price - p.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}