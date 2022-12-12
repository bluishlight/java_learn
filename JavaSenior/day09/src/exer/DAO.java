package exer;

import java.util.*;

public class DAO<K,V> {
    private Map<K,V> map = new HashMap<K,V>();
    // 增
    public void add(K key, V value){
        this.map.put(key,value);
    }
    // 删
    public void delete(K key){
        this.map.remove(key);
    }
    // 改
    public void change(K key, V value){
        if(this.map.containsKey(key)){
            this.map.put(key,value);
        }

    }
    // 查
    public V get(K key){
        return this.map.get(key);
    }
    // 值 返回list
    public List<V> toList(){
        List<V> list= new ArrayList<V>();
        for(Map.Entry<K,V> entry: map.entrySet()){
            list.add(entry.getValue());
        }
//        list = (List<V>)map.values(); //报错 无法强转
        return  list;
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
