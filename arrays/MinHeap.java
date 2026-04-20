package arrays;

class MinHeapException extends Exception {
    public MinHeapException(String message) {
        super(message);
    }
}
public class MinHeap<T extends Comparable<T>> {

    private DynamicArray<T> heap;

    public MinHeap(T[] arr) throws DynamicArrayException {
        this();
        for (T item: arr) {
            add(item);
        }
    }

    public MinHeap() throws DynamicArrayException{
        try {
            this.heap = new DynamicArray<>();
        } catch (StaticArrayException e) {
            throw new DynamicArrayException(
                "Failed to create internal storage: " + e.getMessage()
            );
        }
    }

    @Override
    public String toString() {
        int size, capacity;
        size = heap.length(); capacity = heap.capacity();

        if (size == 0) return "Empty heap";
        
        StringBuilder arrSpecs = new StringBuilder("Size/Cap: " +size+"/"+capacity);
        String arrayType = this.getClass().getSimpleName();
        String type = "Empty";
        try {
            if (heap.get(0) != null) type = heap.get(0).getClass().getSimpleName();

            StringBuilder sb = new StringBuilder(arrayType+"<"+type+">:" +arrSpecs+" [");

            for (int i = 0; i < capacity; i++) {
                sb.append(heap.get(i));
                if (i < capacity - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        } catch (StaticArrayException e) {
            System.out.println("error printing: " +e.getMessage());
        }

        return toString();
    }

    // private int compareTo(T a, T b) {
    //     return a.compareTo(b);
    // }

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
        try {
            if (isEmpty()) {
                throw new MinHeapException("Empty heap");
            }
            if (heap.length() == 1) return heap.pop();

            T minValue = heap.get(0);
            heap.set(0, heap.pop());
            percolateDown(0);
            return minValue; 
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

    private void percolateDown(int parent) {
        percolateDown(0, heap.length());
    }

    private void percolateDown(int parent, int k) {
        try {
            while (0 <= parent && parent < k) {
                // System.out.println(heap);
                int swap = -1;
                int left = 2 * parent + 1;
                int right = 2 * parent + 2;

                if (right < k) {
                    int checkRight = heap.get(parent).compareTo(heap.get(right));
                    if (checkRight > 0) {
                        int checkLR = heap.get(left).compareTo(heap.get(right));
                        swap = (checkLR <= 0) ? left : right;
                    }
                }
                if (left < k) {
                    int checkLeft = heap.get(parent).compareTo(heap.get(left));
                    if (checkLeft > 0 && swap < 0) {
                        swap = left;
                    }
                }
                if (swap < 0) {
                    return;
                }
                swap(parent, swap);
                parent = swap;    
            }
        } catch (StaticArrayException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }


}
