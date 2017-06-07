package future.fry.practice.coding._02_jun;

import java.util.Objects;

/**
 *
 * @author ranjeet
 */
public class BinarySearchTree {

    /*
    Given a binary search tree and a key, 
    return node with this key if it exists or return null.
     */
    public static void main(String[] args) {
         Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        
        Node n = search(root, 7);
        
        System.out.println(n.data);

    }

    private static Node search(Node root, int k) {

        if (Objects.isNull(root)) {
            return null;
        }
        if (root.data == k) {

            return root;
        }

        //go left
        if (k < root.data) {

            return search(root.left, k);

        } else {
            // go right
            return search(root.right, k);
        }

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
