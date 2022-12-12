package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SetReview {
    public static void main(String[] args) {
//        Set set = new HashSet();
//        set.add(1);
//        set.add(3);
//        set.add(3);
//        set.add(5);
////        set.remove(3);
////        Iterator iterator = set.iterator();
////        while (iterator.hasNext()){
////            System.out.println(iterator.next());
////        }
//        for(Object num: set){
//            System.out.println((int) num);
//        }
        Map<String,Integer> map = new HashMap();
        map.put("123",1);
        map.put("jonh",2);
        Set<Map.Entry<String,Integer>>set = map.entrySet();
        for(Map.Entry<String,Integer> entry:  set){
            String key = entry.getKey();
            System.out.println(key+ " "+ entry.getValue());
        }
//        map.remove("123");
//        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String,Integer> entry =  iterator.next();
//            String key = entry.getKey();
//            System.out.println( key+ " "+ entry.getValue());
//        }
    }
}
