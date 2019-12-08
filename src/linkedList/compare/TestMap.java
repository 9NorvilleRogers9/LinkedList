package linkedList.compare;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        TestMap testMap = new TestMap();
        int size = 100000;
        Map<Integer,String> hashMap = new HashMap<>();
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer,String> treeMap = new TreeMap<>();

        System.out.println("Добавление элемента");
        testMap.time(testMap.put(hashMap,size),testMap.put(linkedHashMap,size),testMap.put(treeMap,size));
        System.out.println("Удаление последнего элемента");
        testMap.time(testMap.remove(hashMap,size),testMap.remove(linkedHashMap,size),testMap.remove(treeMap,size));
        System.out.println("Проверка на содержание ключа в середине");
        testMap.time(testMap.contains(hashMap,size),testMap.contains(linkedHashMap,size),testMap.contains(treeMap,size));
    }
    void create(Map<Integer,String> map , int size) {
        for (int i = 0; i < size; i++) {
            map.put(i,"test1");
        }
    }

    long  put(Map<Integer,String> map,int size) {
        TestMap testMap = new TestMap();
        testMap.create(map,size);
        long start = System.nanoTime();
        map.put(size-1,"test2");
        long end = System.nanoTime() - start;
        return end;
    }

    long remove(Map<Integer,String> map, int size) {
        long start = System.nanoTime();
        map.remove(size-1);
        long end = System.nanoTime() - start;
        return end;
    }

    long contains(Map<Integer,String> map,int size) {
        long start = System.nanoTime();
        map.containsKey(size/2);
        long end = System.nanoTime() - start;
        return end;
    }

    void time(long time1, long time2, long time3) {
        if (time1 < time2 && time1 < time3) {
            System.out.println("HashMap faster , time work = " + time1);
        } else if (time2 < time1 && time2 < time3){
            System.out.println("LinkedHashMap faster , time work = " + time2);
        } else if (time3 < time1 && time3 < time2) {
            System.out.println("TreeMap faster , time work = " + time3);
        }
    }
}
