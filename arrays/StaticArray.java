package arrays;

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
    protected T[] data;
    protected int size; // number of elements in array
    protected int capacity; // # of elements array can store

    @SuppressWarnings("unchecked")
    public StaticArray(int capacity) throws StaticArrayException {
        if (capacity < 1) { 
            throw new StaticArrayException("Capacity must be a positive integer"); 
        }
        // cast object to T (workaround)
        data = (T[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    public StaticArray() {
        data = (T[]) new Object[10];
        size = 0;
        capacity = 10;
    }

    @Override
    public String toString() {
        String arrayType = this.getClass().getSimpleName();
        String type = "Empty";
        if (data[0] != null) type = data[0].getClass().getSimpleName();

        StringBuilder sb = new StringBuilder(arrayType+"<"+type+">: [");
        for (int i = 0; i < capacity; i++ ) {
            sb.append(data[i]);
            if (i < capacity - 1) sb.append(", ");
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

    public Boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) throws InvalidIndexException{
        if (index < 0 || index > capacity - 1 ) {
            throw new InvalidIndexException("Index out of bounds");
        }
        return data[index];
    }

    public void set(int index, T item) throws InvalidIndexException {        
        if (index < 0 || index > capacity - 1 ) {
            throw new InvalidIndexException("Index out of bounds");
        }
        // if (data[index] == null) {
        //     size++;
        // }
        data[index] = item;
    }

    public void append(T item) {
        if (size < capacity) {
            data[size] = item;
            size++;
            return;
        } 
        data[capacity - 1] = item;
    }

    public T pop() throws EmptyArrayException{
        if (isEmpty()) {
            throw new EmptyArrayException("Array is empty");
        }
        T value = data[size - 1];
        data[size - 1] = null; 
        size--;
        return value;
    }
}
