package linkedlist;
class LinkedListException extends Exception {
    public LinkedListException(String message) {
        super(message);
    }
}

class EmptyListException extends LinkedListException {
    public EmptyListException(String message) {
        super(message);
    }
}

public class LinkedList<T> {
    protected int size;
    protected Node<T> head;

    public LinkedList() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public String toString() {
        String listType = this.getClass().getSimpleName();
        String type = (size == 0) ? "Empty" : head.next.data.getClass().getSimpleName();

        StringBuilder sb = new StringBuilder(listType+"<"+type+">: { ");
        Node<T> current = head.next; // sentinel node
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
       
            current = current.next;
        }
        sb.append(" }");

        return sb.toString();
    }

    public int size() {
        return size;
    }

    public void insertFront(T data) {
        Node<T> node = new Node<>(data);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void insertBack(T data) {
        Node<T> node = new Node<>(data);
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    public void insert(int index, T data) throws LinkedListException{
        if (index < 0 || index >= size()) {
            throw new LinkedListException("Index out of bounds");
        }  
        Node<T> node = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }
}
