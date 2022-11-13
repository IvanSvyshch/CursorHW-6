package hw6.doublylinkedlist;

public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        private Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public void addFirst(T value) {
        if (isEmpty() || size == 1) {
            addFirstAndSecondAtStartOfList(value);
        } else {
            Node<T> node = new Node<>(value, head, null);
            head.previous = node;
            head = node;
            size++;
        }
    }

    @Override
    public void addLast(T value) {
        if (isEmpty() || size == 1) {
            addFirstAndSecondAtEndOfList(value);
        } else {
            Node<T> node = new Node<>(value, null, tail);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    @Override
    public void add(T value, int index) {
        checkInputIndex(index);
        if (index == 0 || index == 1) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<T> previousNode = getNodeByIndex(index - 1);
            Node<T> nextNode = previousNode.next;
            Node<T> newNode = new Node<>(value, nextNode, previousNode);
            previousNode.next = newNode;
            nextNode.previous = newNode;
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void addFirstAndSecondAtStartOfList(T value) {
        if (isEmpty()) {
            addToEmpty(value);
        } else {
            Node<T> node = new Node<>(value, head, null);
            head.previous = node;
            head = node;
            size++;
        }
    }

    private void addFirstAndSecondAtEndOfList(T value) {
        if (isEmpty()) {
            addToEmpty(value);
        } else {
            Node<T> node = new Node<>(value, null, tail);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    private void addToEmpty(T value) {
        Node<T> node = new Node<>(value, null, null);
        head = node;
        tail = node;
        size++;
    }

    private void checkInputIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of range");
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> searchNode = head;
        for (int i = 0; i < index; i++) {
            searchNode = searchNode.next;
        }
        return searchNode;
    }
}
