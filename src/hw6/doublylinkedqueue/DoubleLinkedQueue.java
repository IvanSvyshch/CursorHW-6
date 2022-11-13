package hw6.doublylinkedqueue;

public class DoubleLinkedQueue<T> implements DoubleLinkedQueueInterface<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T value;
        private Node<T> nextNode;
        private Node<T> previousNode;

        private Node(T value, Node<T> nextNode, Node<T> previousNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }
    }

    @Override
    public void enqueue(T value) {
        if (isEmpty() || size == 1) {
            addFirstAndSecond(value);
        } else {
            Node<T> newNode = new Node<>(value, head, null);
            head.previousNode = newNode;
            head = newNode;
            size++;
        }
    }

    @Override
    public void dequeue() {
        tail = tail.previousNode;
        tail.nextNode = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void addFirstAndSecond(T value) {
        if (isEmpty()) {
            Node<T> newNode = new Node<>(value, null, null);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            Node<T> newNode = new Node<>(value, head, null);
            head.previousNode = newNode;
            head = newNode;
            size++;
        }
    }

}
