package linkedList.compare;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        TestSet testSet = new TestSet();
        int size = 100000;
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        System.out.println("Добавление элемента");
        testSet.time(testSet.add(hashSet,size),testSet.add(linkedHashSet,size),testSet.add(treeSet,size));
        System.out.println("Удаление последнего элемента");
        testSet.time(testSet.remove(hashSet,size),testSet.remove(linkedHashSet,size),testSet.remove(treeSet,size));
        System.out.println("Проерка на содержание элемента в коллекции");
        testSet.time(testSet.contains(hashSet),testSet.contains(linkedHashSet),testSet.contains(treeSet));
    }

    void create(Set set, int size) {
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
    }

    long  add(Set<Integer> set, int size) {
        TestSet testSet = new TestSet();
        testSet.create(set,size);
        long start = System.nanoTime();
        set.add(11);
        long end = System.nanoTime() - start;
        return end;
    }

    long remove(Set<Integer> set, int size) {
        long start = System.nanoTime();
        set.remove(size-1);
        long end = System.nanoTime() - start;
        return end;
    }

    long contains(Set<Integer> set) {
        long start = System.nanoTime();
        set.contains(50000);
        long end = System.nanoTime() - start;
        return end;
    }

    void time(long time1, long time2, long time3) {
        if (time1 < time2 && time1 < time3) {
            System.out.println("HashSet faster , time work = " + time1);
        } else if (time2 < time1 && time2 < time3){
            System.out.println("LinkedHashSet faster , time work = " + time2);
        } else if (time3 < time1 && time3 < time2) {
            System.out.println("TreeSet faster , time work = " + time3);
        }
    }
}
