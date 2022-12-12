package exer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
//        Set set = new HashSet();
        Set set = new TreeSet();
        set.add(123);
        set.add(456);
//        set.add("AA");
//        set.add(new Product("xiaomi",100));
//        set.add(new Product("xiaomi",100));
        System.out.println(set);
        Map map =new HashMap();
        map.put(null, null);
        System.out.println(map);
        map.put("null", null);
        System.out.println(map);
    }
}
