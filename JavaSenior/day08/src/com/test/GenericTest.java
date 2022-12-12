package com.test;

import java.util.*;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        list.add(678);
        list.add(996);

//        for(Integer score: list){
//            System.out.println(score);
//        }
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            int score = iterator.next();
//            System.out.println(score);
//        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("tom",100);
        map.put("jerry",90);
        map.put("jack",180);
        map.put("alice",58);
        map.put("joker",66);
//        System.out.println(map.remove("joker"));
//        System.out.println(map.get("tom"));

//        Set<Map.Entry<String,Integer>> entry = map.entrySet();
//        Iterator<Map.Entry<String,Integer>> iterator2 = entry.iterator();
//        while(iterator2.hasNext()){
//            Map.Entry<String,Integer> e =iterator2.next();
//            Integer value = e.getValue();
//            String key = e.getKey();
//            System.out.println(value+"---"+key);
//        }
        Set<String> keyset = map.keySet();
        for(String obj : keyset){
            System.out.println(obj);
        }
    }
}
