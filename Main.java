public class Main {
    public static void main(String[] args) throws StaticArrayException {
        StaticArray<Integer> sa = new StaticArray<>();
        for (int i = 0; i < sa.capacity() - 1; i++) {
            sa.append(i + 1);
        }

        System.out.println(sa);

        // String[] fruits = {"apple", "banana", "kumquat"};
        // StaticArray<String> sa2 = new StaticArray<>();
        // for (int i = 0; i < 3; i++) {
        //     sa2.append(fruits[i]);
        // }
        
        // System.out.println(sa2);

        // for (int i = sa2.length(); i > 0; i--) {
        //     sa2.pop();
        // }

        // System.out.println(sa2);

        DynamicArray<Integer> da = new DynamicArray<>();
        
        for (int i = 0; i < 10; i++) {
            da.append(i + 1);
            System.out.println(da);
        }

        DynamicArray<String> da2 = new DynamicArray<>();

        for (int i = 0; i < 8; i++) {
            
            da2.append("a" + (i + (i * 2) / 3));
            System.out.println(da);
        }

        System.out.println(da2);
    }

}