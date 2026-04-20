package arrays;

// better with built-ins?
public class DisjointSetUnion {
    private StaticArray<Integer> parent;
    private StaticArray<Integer> size;

    public DisjointSetUnion(int capacity) {
        try {
            parent = new StaticArray<>(capacity);
            size = new StaticArray<>(capacity);

            for (int i = 0; i < capacity; i++) {
                parent.append(i);
                size.append(1);
            }

            } catch (StaticArrayException e) {
                System.out.println(e.getMessage());
            }
    }

    public int find(int x) {
        try {
            int parent =  this.parent.get(x);
            if (parent != x) {
                parent = find(parent);
            }
            return parent;
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
        } 
        return -1;
    }

    public void union(int x, int y) {
        try {
            x = find(x); y = find(y);

            if (x != y) {
                if (size.get(x) < size.get(y)) {
                    int tempX = size.get(x);
                    size.set(x, y);
                    size.set(y, tempX);
                }
                parent.set(y, x);
                int newValueX = size.get(x);
                newValueX += size.get(y);
                size.set(x, newValueX);
            }
        } catch (InvalidIndexException e) {
            System.out.print(e.getMessage());
        }
    }
}
