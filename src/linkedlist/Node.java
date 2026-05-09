package linkedlist;

public class Node<T> {
    protected T data;
    protected Node<T> prev;
    protected Node<T> next;

    public Node(T data, Node<T> next, Node<T>prev) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(T data, Node<T> next) {
        this(data, next, null);
    }

    public Node(T data) {
        this(data, null, null);
    }
}
