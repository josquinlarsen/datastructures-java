package trees;

import arrays.DynamicArray;
import arrays.StaticArrayException;

class BSTException extends Exception{
    public BSTException(String message) {
        super(message);
    }
}

// class NodePair<T> {
//     private final TreeNode<T> parent;
//     private final TreeNode<T> child;
    
//     public NodePair(TreeNode<T> parent, TreeNode<T> child) {
//         this.parent = parent;
//         this.child = child;
//     }
// }

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
            else node = node.right; // allow duplicates (?)
        }
        TreeNode<T> addNode = new TreeNode<>(data);
        if (parent == null) {
            root = addNode;
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
    }

    public Boolean remove(T value) {
        TreeNode<T> node = find(value);
        if (node == null) return false;
        TreeNode<T> parent = node.parent;

        if (node.left == null && node.right == null) {
            removeNoSubtrees(parent, node);
        } else if (node.left == null || node.right == null) {
            removeOneSubtree(parent, node);
        } else removeTwoSubtrees(parent, node);

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
    // private NodePair<T> inOrderSuccesssor(TreeNode<T> node) {
       
    //     TreeNode<T> parent = null;
    //     TreeNode<T> successor = node.right;

    //     while (successor.left != null) {
    //         parent = successor;
    //         successor = successor.left;
    //     }

    //     NodePair<T> result = new NodePair<>(parent, successor);
        
    //     return result;
    // }

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
        if (parent != null) {
            if (parent.left == node) parent.left = replaceNode;
            else parent.right = replaceNode;
        } else root = replaceNode;
    }

    private void removeNoSubtrees(TreeNode<T> parent, TreeNode<T> node) {
        replace(parent, node);
    }

    private void removeOneSubtree(TreeNode<T> parent, TreeNode<T> node) {
        // root case
        if (isRoot(node)) {
            if (node.left != null) {
                root = node.left;
            } else root = node.right;
            return;
        }
        // parent left child = remove node
        if (parent.left == node) {
            if (node.left != null) {
                parent.left = node.left;
            } else parent.left = node.right;
        } else {
            if (node.left != null) {
                parent.right = node.left;
            } else parent.right = node.right;
        }
    }

    private void removeTwoSubtrees(TreeNode<T> parent, TreeNode<T> node) {
        TreeNode<T> successor = inOrderSuccessor(node); // have 0 or 1 (right) child
        TreeNode<T> parentSuccessor = successor.parent;

        successor.left = node.left;
        
        if (successor != node.right) {
            parentSuccessor.left = successor.right;
            successor.right = node.right;
        }

        replace(parent, node, successor);
    }

}
