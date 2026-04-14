package trees;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        BST<Integer> bst0 = new BST<>();
        BST<Integer> bst1 = new BST<>();
        BST<Integer> bst2 = new BST<>();
        BST<Integer> bst3 = new BST<>();
        BST<Integer> bst4 = new BST<>();
        BST<Integer> bst5 = new BST<>();
        BST<Integer> bst6 = new BST<>();
        BST<Integer> bst7 = new BST<>();
        BST<Integer> bst8 = new BST<>();
        BST<Integer> bst9 = new BST<>();
        BST<Integer> bst10 = new BST<>();
        BST<Integer> bst11 = new BST<>();
        BST<Integer> bst12 = new BST<>();

        int[] arr = {1, -7, 18, 3, 72, 55, 4};
        int[] arr1  = {20, -10, 30, -15, 5, 25};                                     // remove leaf: -15 or 25
        int[] arr2  = {40, -20, 60, -30, 10, 50, 70};                                // remove root with 2 children: 40
        int[] arr3  = {50, -30, 70, -40, 20, 60, 80, 35};                            // remove node with 1 right child: 20→35
        int[] arr4  = {-25, -50, 35, -60, -30, 10, 40, -55, -35};                    // remove leaf deep in tree: -55 or -35
        int[] arr5  = {60, -40, 80, -50, 20, 70, 90, -5, 45, 55};                    // remove node with 2 children: 20
        int[] arr6  = {30, -15, 45, -25, 10, 35, 50, -30, -5, 5, 25};                // remove node with 1 left child: 10→-5
        int[] arr7  = {-70, -90, 40, -95, -80, 20, 60, -85, -75, -10, 30, 50};       // remove node with 2 children: -80
        int[] arr8  = {55, -30, 75, -40, 20, 65, 85, -35, -5, 35, 60, 70, 80};       // remove root: 55, successor is 60
        int[] arr9  = {-45, -65, 25, -75, -55, 15, 35, -70, -60, -50, 20};           // remove node with 1 right child: -65→-55
        int[] arr10 = {80, -50, 100, -70, 30, 90, 110, -75, -60, 10, 50};            // remove leaf: -75 or 10
        int[] arr11 = {35, -20, 55, -30, 10, 45, 65, -35, -25, -5, 15, 50};          // remove node with 2 children: -20
        int[] arr12 = {-90, -120, 60, -135, -105, 40, 75, -140, -110, -100, 50, 70, 80};
        
        for (int n : arr) {
            bst.add(n);
        }
        for (int n : arr1) {
            bst1.add(n);
        }
        for (int n : arr2) {
            bst2.add(n);
        }
        for (int n : arr3) {
            bst3.add(n);
        }
        for (int n : arr4) {
            bst4.add(n);
        }
        for (int n : arr5) {
            bst5.add(n);
        }
        for (int n : arr6) {
            bst6.add(n);
        }
        for (int n : arr7) {
            bst7.add(n);
        }
        for (int n : arr8) {
            bst8.add(n);
        }
        for (int n : arr9) {
            bst9.add(n);
        }
        for (int n : arr10) {
            bst10.add(n);
        }
        for (int n : arr11) {
            bst11.add(n);
        }
        for (int n : arr12) {
            bst12.add(n);
        }
        
        // System.out.println(bst.validBST());
        // System.out.println(bst.contains(55));
        // System.out.println(bst.contains(27));
        // System.out.println("Remove bst:");
        // System.out.println(bst.remove(1));
        // System.out.println(bst);

        // System.out.println("Remove bst1:");
        // System.out.println(bst1);
        // System.out.println(bst1.remove(-15));
        // System.out.println(bst1);

        // System.out.println("Remove bst2:");
        // System.out.println(bst2);
        // System.out.println(bst2.remove(40));
        // System.out.println(bst2);

        // System.out.println("Remove bst3:");
        // System.out.println(bst3);
        // System.out.println(bst3.remove(20));
        // System.out.println(bst3);

        // System.out.println("Remove bst4:");
        // System.out.println(bst4);
        // System.out.println(bst4.remove(-55));
        // System.out.println(bst4);

        // System.out.println("Remove bst5:");
        // System.out.println(bst5);
        // System.out.println(bst5.remove(20));
        // System.out.println(bst5);

        // System.out.println("Remove bst6:");
        // System.out.println(bst6);
        // System.out.println(bst6.remove(10));
        // System.out.println(bst6);

        // System.out.println("Remove bst7:");
        // System.out.println(bst7);
        // System.out.println(bst7.remove(-80));
        // System.out.println(bst7);

        // System.out.println("Remove bst8:");
        // System.out.println(bst8);
        // System.out.println(bst8.remove(60));
        // System.out.println(bst8);

        // System.out.println("Remove bst9:");
        // System.out.println(bst9);
        // System.out.println(bst9.remove(-65));
        // System.out.println(bst9);

        // System.out.println("Remove bst10:");
        // System.out.println(bst10);
        // System.out.println(bst10.remove(10));
        // System.out.println(bst10);

        // System.out.println("Remove bst11:");
        // System.out.println(bst11);
        // System.out.println(bst11.remove(-20));
        // System.out.println(bst11);

        // System.out.println("Remove bst12:");
        // System.out.println(bst12); 
        // System.out.println(bst12.remove(-105));

        // System.out.println(bst0);

        // System.out.println(bst12);
        System.out.println(bst12.preOrder());
        for (int i = 0; i < 8; i++) {
            System.out.println("Remove node: "+arr12[i]);
            bst12.remove(arr12[i]);
            System.out.println(bst12.preOrder());
            // System.out.println(bst12.inOrder());
        }
        System.out.println(bst12);
        // bst12.remove(-90);
        // System.out.println(bst12);
        // System.out.println(bst12.preOrder());

        // bst12.remove(40);
        // System.out.println(bst12);
        // System.out.println(bst12.preOrder());

        // bst12.remove(50);
        // System.out.println(bst12);
        // System.out.println(bst12.preOrder());

        // System.out.println(bst12);

    }

}

