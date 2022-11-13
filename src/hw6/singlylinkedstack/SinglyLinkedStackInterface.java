package hw6.singlylinkedstack;

public interface SinglyLinkedStackInterface<T> {
    void push(T value);

    void pop();

    Object top();

    int size();

    boolean isEmpty();
}
