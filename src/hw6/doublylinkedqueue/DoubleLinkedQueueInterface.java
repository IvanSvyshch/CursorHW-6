package hw6.doublylinkedqueue;

public interface DoubleLinkedQueueInterface<T> {
    void enqueue(T value);

    void dequeue();

    int size();

    boolean isEmpty();
}
