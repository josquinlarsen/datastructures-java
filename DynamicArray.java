class DynamicArrayException extends StaticArrayException {
    public DynamicArrayException(String message) {
        super(message);
    }
}

public class DynamicArray<T> extends StaticArray<T>{

    public DynamicArray(int capacity) throws DynamicArrayException, StaticArrayException{
        super(capacity);
    }
    
    public DynamicArray() throws DynamicArrayException, StaticArrayException{
        super(4);
    }

    @Override
    public String toString() {
        StringBuilder arrSpecs = new StringBuilder("Size/Cap: " +size+"/"+capacity);
        String arrayType = this.getClass().getSimpleName();
        String type = "Empty";
        if (data[0] != null) type = data[0].getClass().getSimpleName();

        StringBuilder sb = new StringBuilder(arrayType+"<"+type+">:" +arrSpecs+" [");

        for (int i = 0; i < capacity; i++ ) {
            sb.append(data[i]);
            if (i < capacity - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    private void resize(int newCapacity) throws DynamicArrayException{
        if (newCapacity > 0 && newCapacity > size) {
            try {
            StaticArray<T> newArray = new StaticArray<>(newCapacity);
 
            for (int i = 0; i < size; i++) {
                newArray.data[i] = data[i];
            }
            data = newArray.data;
            capacity = newCapacity;
            } catch (StaticArrayException e) {
                System.out.println("Resize error: " + e.getMessage());
            }
        }
    }

    private void downsize() {
        try {
            int newCapacity = Math.max(capacity / 2, 10);
            resize(newCapacity);
        } catch (DynamicArrayException e) {
            System.out.println("Resize error: " + e.getMessage());
        }  
    }

    @Override
    public void append(T item) {
        if (capacity == size) {
            try {
                resize(capacity * 2);
            } catch (DynamicArrayException e) {
                System.out.println("Resize error: " + e.getMessage());
            }
            
        }
        data[size] = item;
        size++;
    }

    public void remove(int index) throws EmptyArrayException, InvalidIndexException {
        if (isEmpty()) {
            throw new EmptyArrayException("Array is empty");
        }
        if (0 > index || index >= size) {
            throw new InvalidIndexException("Invalid index");
        }
        if (size * (0.25) < capacity ) downsize();

        data[index] = null;
        for (int i = index; i < size; i++) {
            data[i] = data[i +1];
        }
        size--;
    }

    public void insert(T item, int index) throws InvalidIndexException {
        if (0 > index || index > size) {
            throw new InvalidIndexException("Invalid index");
        }
        if (size == capacity) {
            try {
                resize(capacity * 2);
            } catch (DynamicArrayException e) {
                System.out.println("Resize error: " + e.getMessage());
            }
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    public T pop() throws EmptyArrayException {
        if (isEmpty()) {
            throw new EmptyArrayException("Array is empty");
        }
        if (size * (0.25) < capacity ) downsize();
        T item = data[size - 1];
        data[size - 1] = null;
        size--;
        return item;
    }
}
