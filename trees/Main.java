package trees;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {1, -7, 18, 3, 72, 55, 4};
        for (int n : arr) {
            bst.add(n);
        }
        System.out.print(bst);
        System.out.println(bst.validBST());
    }
}
