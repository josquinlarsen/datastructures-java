package trees;

class BSTException extends Exception{
    public BSTException(String message) {
        super(message);
    }
}
public class BST<T> extends BinaryTree<T>{
    public BST() {
        super();
    }

    public void add(T data) {

        TreeNode<T> parent = null;
        TreeNode<T> node = root; 

        while (node != null) {
            parent = node;
            if (data < node.data) node = node.left;
            else node = node.right;
        }
        TreeNode<T> addNode = new TreeNode<>(data);
        if (parent == null) root = addNode;
        else if (data < parent.left.data) parent.left = addNode;
        else parent.right = addNode;
    }
}
