package linkedlist;

class DoublyLinkedListException extends LinkedListException {
    public DoublyLinkedListException(String message) {
        super(message);
    }
}

public class DoublyLinkedList<T> extends LinkedList<T> {
    protected Node<T> tail;

    public DoublyLinkedList() {
        super();
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }
}
