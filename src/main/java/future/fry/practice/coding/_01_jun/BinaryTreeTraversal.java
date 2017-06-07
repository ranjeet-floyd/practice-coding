package future.fry.practice.coding._01_jun;

/**
 *
 * @author ranjeet
 */
public class BinaryTreeTraversal {

    /*
    Preorder, inorder and postorder traversal of binary tree
     */
    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        
        System.out.println("***** PreOrder");
        preOrder(root);

        System.out.println("**** Inorder ");
        inOrder(root);

        System.out.println("**** Postorder ");
        postOrder(root);
    }

    /*
    Visit root, left and right node
     */
    private static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }

    /*
    Visit left, root and right node
     */
    private static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    /*
    Visit left, right and root node
     */
    private static void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);

        postOrder(root.right);

        System.out.println(root.data);

    }

    public static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
}
