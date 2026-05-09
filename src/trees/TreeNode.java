package trees;
public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> parent;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    public TreeNode(T data) {
        this.data =  data;
        parent = null;
        left = null;
        right = null;
    }

    @Override 
    public String toString() {
        return "TreeNode: data=" + this.data
            + " parent=" + (parent != null ? parent.data : "null")
            + " left="   + (left   != null ? left.data   : "null")
            + " right="  + (right  != null ? right.data  : "null");
    }
}
