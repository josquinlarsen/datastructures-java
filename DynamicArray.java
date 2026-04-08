class DynamicArrayException extends StaticArrayException {
    public DynamicArrayException(String message) {
        super(message);
    }
}

public class DynamicArray<T> extends StaticArray<T>{

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) throws DynamicArrayException, StaticArrayException{
        super(capacity);
    }
    
    public DynamicArray() throws DynamicArrayException, StaticArrayException{
        super(4);
    }

    @Override
    public String toString() {
        StringBuilder arrSpecs = new StringBuilder("Size/Cap: " +size+"/"+capacity);

        String type = "Empty";
        if (data[0] != null) type = data[0].getClass().getSimpleName();

        StringBuilder sb = new StringBuilder("DynamicArray<"+type+">:" +arrSpecs+" [");
        for (int i = 0; i < capacity; i++ ) {
            sb.append(data[i]);
            if (i < capacity - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    private void resize(T[] arr, int newCapacity) throws DynamicArrayException{
        if (newCapacity > 0 && newCapacity > size) {
            DynamicArray<T> newArray = new DynamicArray<>(newCapacity);

            for (int i = 0; i < size; i++) {
                newArray.data[i] = arr[i];
            }
            data = newArray.data;
            capacity = newCapacity;
        }
    }

    @Override
    public void append(T item) {
        if (capacity == size) {
            try {
                resize(data, capacity * 2);
            } catch (DynamicArrayException e) {
                System.out.println("Resize error: " + e.getMessage());
            }
            
        }
        data[size] = item;
        size++;
    }
}
