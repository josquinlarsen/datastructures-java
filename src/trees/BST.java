package trees;

import arrays.DynamicArray;
import arrays.Stack;
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
        if (size() == 0 || getRoot() == null) {
            return "Empty Tree";
        }
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
            sb.append(toStringHelper(node.left,  depth + 1, "L: "));
            sb.append(toStringHelper(node.right, depth + 1, "R: "));
        } 
        
        return sb.toString();
    }

    public DynamicArray<T> inOrder() {
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

    public DynamicArray<T> preOrder() {
        DynamicArray<T> arr = null; 
        try { 
            arr = new DynamicArray<>();
            preOrderHelper(root, arr); 
            return arr;
        } catch (StaticArrayException e) {
            System.out.println("error: " + e.getMessage());
        }  

        return arr;
    }

    private void preOrderHelper(TreeNode<T> node, DynamicArray<T> arr) {
        if (node == null) {
            return;
        }
        arr.append(node.data);
        preOrderHelper(node.left, arr);
        preOrderHelper(node.right, arr);
    }

    public Boolean validBST() {
        try {
            Stack<TreeNode<T>> stack = new Stack<>();
            stack.push(root);
            while (stack.isEmpty() == false) {
                TreeNode<T> node = stack.pop();
                if (node != null) {
                    if (node.left != null) {
                        int check = node.left.data.compareTo(node.data);
                        if (check >= 0) {
                            System.out.println("Invalid BST.");
                            return false;
                        }
                    } 
                    if (node.right != null) {
                        int check = node.right.data.compareTo(node.data);
                        if (check < 0) {
                            System.out.println("Invalid BST.");
                            return false;
                        }
                    }
                }
            }
        } catch (StaticArrayException e){
            System.out.println("error: " +e.getMessage());
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
            else node = node.right; // allow duplicates (?)
        }
        TreeNode<T> addNode = new TreeNode<>(data);
        if (parent == null) {
            root = addNode;
            size++;
            return;
        }
        int compare = compareTo(data, parent.data);
        if (compare < 0) {
            parent.left = addNode;
        }
        else {
            parent.right = addNode;
        }
        addNode.parent = parent;
        size++;
    }

    public Boolean remove(T value) {
        TreeNode<T> node = find(value);
        if (node == null) return false;
        TreeNode<T> parent = node.parent;
     
        if (node.left == null && node.right == null) {
            removeNoSubtrees(parent, node);
        } else if (node.left != null && node.right != null) {
            removeTwoSubtrees(parent, node);
        } else removeOneSubtree(parent, node);
        size--;
        return true;
    }

    public Boolean contains(T value) {
        if (root != null) {
            TreeNode<T> node = root;
            while (node != null) {
                int check = value.compareTo(node.data);
                if (check == 0) return true;
                if (check < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return false;
    }

    private TreeNode<T> find(T value) {
        if (root != null) {
            TreeNode<T> node = root;
            while (node != null) {
                int check = value.compareTo(node.data);
                if (check == 0) return node;
                if (check < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }

    private TreeNode<T> inOrderSuccessor(TreeNode<T> node) {
        TreeNode<T> successor = node.right;

        while (successor.left != null) {
            successor = successor.left;
        }

        return successor;
    }

    // zero subtree / remove leaf
    private void replace(TreeNode<T> parent, TreeNode<T> node) {
        replace(parent, node, null);
    }

    private void replace(TreeNode<T> parent, TreeNode<T> node, TreeNode<T> replaceNode) {
        if (parent == null) {
            root = replaceNode;
        } else if (parent.left == node) { 
            parent.left = replaceNode;
        } else parent.right = replaceNode;
            
        if (replaceNode != null) {
            replaceNode.parent = parent;
        }
    }

    private void removeNoSubtrees(TreeNode<T> parent, TreeNode<T> node) {
        replace(parent, node);
    }

    private void removeOneSubtree(TreeNode<T> parent, TreeNode<T> node) {
        TreeNode<T> child = (node.left != null) ? node.left : node.right;
        replace(parent, node, child);
    }

    private void removeTwoSubtrees(TreeNode<T> parent, TreeNode<T> node) {
        TreeNode<T> successor = inOrderSuccessor(node); // have 0 or 1 (right) child
        if (successor.right != node.right) { // inOrder successor is not right node + leaf
            replace(successor.parent, successor, successor.right);
            successor.right = node.right;
            if (successor.right != null) {
                successor.right.parent = successor;
            }
        }
        
        successor.left = node.left; // reattach left
        if (successor.left != null) {
            successor.left.parent = successor;
        }
        
        replace(parent, node, successor);     
    }

}
