package linkedList;

import java.util.LinkedList;
import java.util.List;

public class MyLLvsLL {
    public static void main(String[] args) {


    MyLLvsLL myLLvsLL = new MyLLvsLL();
        myLLvsLL.vs();

}
    void vs() {
        long startMyCol = System.nanoTime();
        MyLinkedList<String> mylist = new MyLinkedList<>();
        for (int i = 0; i < 10000; i++) {
            mylist.add("test1");
        }
        for (int i = 0; i < mylist.size(); i++) {
            if (i % 2 == 0) {
                mylist.remove(i);
            }
        }
        for (int i = 0; i < mylist.size(); i++) {
            mylist.set(i,"test2");
        }
        mylist.clear();
        long endMyCol = System.nanoTime() - startMyCol;

        long startJavaCol = System.nanoTime();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add("test1");
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i,"test2");
        }
        list.clear();
        long endJavaCol = System.nanoTime() - startJavaCol;

        if (endMyCol <endJavaCol) {
            System.out.println("myLinkedList faster time work = : " + endMyCol);
        } else if (endMyCol> endJavaCol) {
            System.out.println("JavaLinkedList faster time work = : " + endJavaCol);
        }
    }
}
