package trees;

class BTException extends Exception{
    public BTException(String message) {
        super(message);
    }
}

public class BinaryTree<T> {
    protected TreeNode<T> root;
    protected int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public Boolean isRoot(TreeNode<T> node) {
        return node == root;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public int countChildren(TreeNode<T> node) {
        int total = 0;

        if (node.left != null) total++;
        if (node.right != null) total++;

        return total;
    }

    public int depth(TreeNode<T> node) {
        if (isRoot(node)) return 0;
        return 1 + depth(node.parent);
    }
    
}