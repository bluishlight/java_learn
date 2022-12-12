package exer;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("AA",456);
        System.out.println(map);
        Map map2 = new HashMap();
        map2.put("cc","lallal");
        map2.put("dd",0);
        map.putAll(map2);
        System.out.println(map);
//        map.remove("cc");
//        System.out.println(map);
//        System.out.println(map.containsKey(45));
//        System.out.println(map.containsValue(123));

//        map.clear();
        Set keyset = map.keySet();
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("#####");
        Collection values = map.values();
        for(Object obj: values){
            System.out.println(obj);
        }

        System.out.println(map);
        System.out.println(map instanceof Map);

    }
}
