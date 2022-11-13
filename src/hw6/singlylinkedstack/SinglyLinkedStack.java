package hw6.singlylinkedstack;

public class SinglyLinkedStack<T> implements SinglyLinkedStackInterface<T> {
    private int size;
    private Node<T> tailNode;
    private Node<T> headNode;

    private static class Node<T> {
        private T value;
        private Node<T> nextNode;

        private Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    public void push(T value) {
        if (isEmpty()) {
            addFirst(value);
        } else {
            Node<T> newNode = new Node<>(value, null);
            tailNode.nextNode = newNode;
            tailNode = newNode;
            size++;
        }
    }

    public Node<T> top() {
        return getNodeByIndex(size - 1);
    }

    public void pop() {
        tailNode = getNodeByIndex(size - 2);
        tailNode.nextNode = null;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void addFirst(T value) {
        Node<T> newNode = new Node<>(value, null);
        tailNode = newNode;
        headNode = newNode;
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> searchNode = headNode;
        for (int i = 0; i < index; i++) {
            searchNode = searchNode.nextNode;
        }
        return searchNode;
    }
}
