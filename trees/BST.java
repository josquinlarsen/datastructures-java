package trees;
import arrays.DynamicArray;
import arrays.StaticArrayException;

class BSTException extends Exception{
    public BSTException(String message) {
        super(message);
    }
}
public class BST<T extends Comparable<T>> extends BinaryTree<T> {
    public BST() {
        super();
    }

    private int compareTo(T a, T b) {
        return a.compareTo(b);
    }

    @Override
    public String toString() {
        return toStringHelper(root, 0, "Root: ");
    }

    private String toStringHelper(TreeNode<T> node, int depth, String prefix) {
        if (node == null) return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append("    ".repeat(depth))
        .append(prefix)
        .append(node.data)
        .append("\n");
        
        if (node.left != null || node.right != null) {
            sb.append(toStringHelper(node.right, depth + 1, "R: "));
            sb.append(toStringHelper(node.left,  depth + 1, "L: "));
        }
        
        return sb.toString();
    }

    private DynamicArray<T> inOrder() {
        DynamicArray<T> arr = null; 
        try { 
            arr = new DynamicArray<>();
            inOrderHelper(root, arr); 
            return arr;
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }  

        return arr;
    }

    private void inOrderHelper(TreeNode<T> node, DynamicArray<T> arr) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, arr);
        arr.append(node.data);
        inOrderHelper(node.right, arr);
    }

    public Boolean validBST() {
        DynamicArray<T> arr = inOrder();
        for (int i = 0; i < size - 1; i++) {
            try {
                int check = arr.get(i).compareTo(arr.get(i - 1));
                if (check < 0) {
                    System.out.print("invalid BST");
                    return false;
                }
            } catch (StaticArrayException e) {
                System.out.println("Invalid index: " + e.getMessage());
            }
        }
        System.out.println("Valid BST");
        return true;
    }


    public void add(T data) {

        TreeNode<T> parent = null;
        TreeNode<T> node = root; 

        while (node != null) {
            parent = node;
            int compare = compareTo(data, node.data);
            if (compare < 0) node = node.left;
            else node = node.right;
        }
        TreeNode<T> addNode = new TreeNode<>(data);
        if (parent == null) {
            root = addNode;
            return;
        }
        int compare = compareTo(data, parent.data);
        if (compare < 0) parent.left = addNode;
        else parent.right = addNode;
    }
}
