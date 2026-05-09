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

        if (size == 0) {
            sb.append(" }");
            return sb.toString();
        }

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

    public Boolean isEmpty() {
        return size == 0;
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

    public void removeAtIndex(int index) throws LinkedListException {
        if (isEmpty()) throw new LinkedListException("Can't remove from empty list");
        if (index < 0 || index >= size()) {
            throw new LinkedListException("Index out of bounds");
        }
        Node<T> current = head;
        Node<T> prev = null;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        for (int i = 0; i < index; i++)  {
            prev = current;
            current = current.next;
        }
        
        prev.next = current.next;
        size--;
    }
    // remove all instaces of a value
    public Boolean remove(T item) {
        Node<T> current = head;
        Node<T> prev = null;
        Boolean removed = false;

        if (head.data == item) {
            head = head.next;
            removed = true;
            size--;
            current = head.next;
        }

        while (current.next != null) {
            if (current.data == item) {
                prev.next = current.next;
                size--;
                removed = true;
            }
            prev = current;
            current = current.next;
        }
        
        return removed;
    }


}
