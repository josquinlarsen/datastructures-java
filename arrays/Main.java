package arrays; 

public class Main {
    public static void main(String[] args) throws StaticArrayException {
        // StaticArray<Integer> sa = new StaticArray<>();
        // for (int i = 0; i < sa.capacity() - 1; i++) {
        //     sa.append(i + 1);
        // }

        // Queue<Integer> q = new Queue<>();
        //  for (int i = 0; i < 8; i++) {
        //     q.enqueue(i + 1);
        //     System.out.println(q);
        // }

        MinHeap<Integer> h = new MinHeap<>();
        
        for (int i = 10; i > -1; i--) {
            h.add(i);
            System.out.println(h);
        }
    }
}