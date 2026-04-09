package arrays;

class QueueException extends StaticArrayException {
    QueueException(String message) {
        super(message);
    }
}

public class Queue<T> extends StaticArray<T> {
    private int front;
    private int back;

    public Queue() throws QueueException, StaticArrayException {
        super(4);
        front = 0;
        back = 0;
    }

    private int increment(int index) {
        index++;
        if (index == size) {
            index = 0;
        }
        return index;
    }
    
    public void enqueue(T item) {
        System.out.print("size before: "+size+ " ");
        if (size == capacity) { resize(capacity * 2); }
        System.out.println("size after" +size +" ");
        try {
            set(back, item);
            back = increment(back);
            size++;
        } catch (InvalidIndexException e) {
            System.out.println("Invalid index: " + e.getMessage());
        }
    }

    public T dequeue() throws QueueException {
        if (isEmpty()) { throw new QueueException("Queue is empty");}
        
        T item = data[front];
        front = increment(front);
        size--;
        return item;

    }

    private void resize(int newCapacity) {
        try {
            StaticArray<T> arr = new StaticArray<>(newCapacity);
            for (int i = 0; i < capacity; i++) {
                arr.data[i] = data[front];
                front = increment(front);
            }

            front = 0;
            back = size;
            capacity = newCapacity;
            data = arr.data;

        } catch (StaticArrayException e) {
            System.out.print("Resize error: " + e.getMessage());
        }
    }
}
