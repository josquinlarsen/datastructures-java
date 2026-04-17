package arrays;

class MinHeapException extends Exception {
    public MinHeapException(String message) {
        super(message);
    }
}
public class MinHeap<T extends Comparable<T>> extends DynamicArray<T> {

    private DynamicArray<T> heap;

    public MinHeap() throws DynamicArrayException, StaticArrayException{
        super();
        try {
            DynamicArray<T> heap = new DynamicArray<>();
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private int compareTo(T a, T b) {
        return a.compareTo(b);
    }

    public void add(T value) {
        heap.append(value);
        percolateUp(heap.length() - 1);
    }

    public T getMin() throws MinHeapException{
        if (isEmpty()) throw new MinHeapException("Empty heap");
        try {
            return heap.get(0);
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }
        return null;
    }

    public T removeMin() throws MinHeapException{
        if (isEmpty()) throw new MinHeapException("Empty heap");
        try {
            return heap.get(0); // placeholder - TODO
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }
        return null;
    }

    public Boolean isEmpty() {

        return heap.length() == 0;
    }

    private void percolateUp(int idx) {
        try{ 
            int parent;
            while (idx > 0) {
                parent = (idx - 1) / 2;
                int check = heap.get(parent).compareTo(heap.get(idx));
                if (check > 0) {
                    swap(parent, idx);
                }
                idx = parent;
            }
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }
        
    }

    private void swap(int a, int b) {
        try {
            T temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private void percolateDown(T child) {

    }

}
