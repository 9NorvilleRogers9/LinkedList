package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("Добавляем элементы в коллекцию");
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add(5,"Test4");
        System.out.println("Выводим элементы из коллекции");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("Кол-во элементов в коллекции:"+list.size());

        System.out.println("Получим индекс элемента Test2");

        System.out.println(list.indexOf("Test3"));

        System.out.println("Удалим эоемент с индексом 3");

        list.remove(3);

        System.out.println("Размер коллекции после удалания:"+list.size());

        System.out.println(list.toString());

        System.out.println("Изменим значения элементов по индексам:");

        list.set(1,"NewValue");
        list.set(2,"New..");

        Iterator iterator1 = list.iterator();

        while (iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }

        System.out.println(list.toString());
        System.out.println("Очищаем коллекцию");
        list.clear();
        System.out.println("Размер после очистки:"+list.size());

    }
}
