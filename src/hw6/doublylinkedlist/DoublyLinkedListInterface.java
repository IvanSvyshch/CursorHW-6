package hw6.doublylinkedlist;

public interface DoublyLinkedListInterface<T> {
    void addFirst(T value);

    void addLast(T value);

    void add(T value, int index);

    int size();

    boolean isEmpty();
}
