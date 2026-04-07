class StaticArrayException extends Exception {
    public StaticArrayException(String message) {
        super(message);
    }
}

class InvalidIndexException extends StaticArrayException {
    public InvalidIndexException(String message) {
        super(message);
    }
}

class EmptyArrayException extends StaticArrayException {
    public EmptyArrayException(String message) {
        super(message);
    }
}

public class StaticArray<T> {
    // T = Generic, to handle flexible types
    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public StaticArray(int capacity) throws StaticArrayException {
        if (capacity < 1) { 
            throw new StaticArrayException("Capacity must be a positive integer"); 
        }
        // cast object to T (workaround)
        data = (T[]) new Object[capacity];
        size = capacity;
        this.capacity = 0;
    }

    @SuppressWarnings("unchecked")
    public StaticArray() {
        data = (T[]) new Object[10];
        size = 10;
        capacity = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("StaticArray: [");
        for (int i = 0; i < size; i++ ) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    public int length() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public T get(int index) throws InvalidIndexException{
        if (index < 0 || index > size - 1 ) {
            throw new InvalidIndexException("Index out of bounds");
        }
        return data[index];
    }

    public void set(int index, T item) throws InvalidIndexException {        
        if (index < 0 || index > size - 1 ) {
            throw new InvalidIndexException("Index out of bounds");
        }
        data[index] = item;
    }

    public void append(T item) {
        if (capacity < size) {
            data[capacity] = item;
            capacity++;
            return;
        } 
        data[size - 1] = item;
    }


}
