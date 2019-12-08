package linkedList;

import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<E> implements IlinkedList<E>{

    private int size=0;

    private Node<E> first;

    private Node<E> last ;


    public MyLinkedList() {
        super();
    }

   @Override
    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e,null,l);
        last = newNode;
        if (l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if(index >=0 && index <=size) {
            Node<E> newNode = new Node(e, node(index), node(index).prev);
            node(index).prev = newNode;
            node(index - 1).next = newNode;
            size++;
        }
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    @Override
    public void clear() {
        for (Node<E> x = first; x != null;) {
            Node<E> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        E item=null;
        if (index >= 0 && index <= size)
        {
            item=node(index).item;
        }
        return item;
    }

    @Override
    public E remove(int index) {

        Node<E> rem = node(index);
        E value = rem.item;

        if(rem==last)
        {
            last = rem.prev;
            rem.prev.next=null;

        }
        else  if (rem==first)
        {
            first = rem.next;
            rem.next.prev=null;
        }
        else
        {
            rem.prev.next = rem.next;
            rem.next.prev = rem.prev;
        }
        rem.item=null;
        rem.prev=null;
        rem.next=null;
        size--;

        return value;
    }

    @Override
    public E set(int index, E element) {
        if (index >= 0 && index <= size)
        {
            node(index).item=element;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> cur = first;
            @Override
            public boolean hasNext() {
                return cur!=null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = cur.item;
                    cur = cur.next;
                    return value;
                }
                return null;
            }

        };
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < size) {
            array = (E[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = array;
        for (Node<E> temp = first; temp != null; temp = temp.next) {
            result[i++] = temp.item;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(Node<E> temp = first; temp != null; temp = temp.next) {
            array[i++] = temp.item;
        }

        return array;
    }
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    private static class Node<E>
    {
        E item;
        Node next;
        Node prev;

        public Node(E item, Node<E> next, Node<E> prev ) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
