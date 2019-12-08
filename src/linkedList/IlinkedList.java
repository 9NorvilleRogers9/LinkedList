package linkedList;

public interface IlinkedList<E> extends Iterable<E>{

    void add (E e);

    void add(int index, E e);

    void clear();

    E get(int index);

    E remove(int index);

    E set(int index, E element);

    int size();

    int indexOf(Object o);

    E[] toArray(E[] array);

    Object[] toArray();

    String toString();


}
