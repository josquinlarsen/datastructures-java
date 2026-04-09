public class Main {
    public static void main(String[] args) throws StaticArrayException {
        StaticArray<Integer> sa = new StaticArray<>();
        for (int i = 0; i < sa.capacity() - 1; i++) {
            sa.append(i + 1);
        }

        // System.out.println(sa);

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
        System.out.println(da);
        for (int i = 0; i < 10; i++) {
            da.insert(i + 1, i);
            System.out.println(da);
        }

        // System.out.println(da);
        // int end = da.length();
        // for (int i = (end - 1); i > 0; i--) {
        //     da.remove(i);
        //     System.out.println(da);
        // }
        
        // for (int i = 0; i > end; i++) {
        //     da.insert(27, 0);
        //     System.out.println(da);
        // }

    //     DynamicArray<String> da2 = new DynamicArray<>();

    //     for (int i = 0; i < 8; i++) {
            
    //         da2.append("a" + (i + (i * 2) / 3));
    //         System.out.println(da);
    //     }

    //     System.out.println(da2);
    }

}