package future.fry.practice.coding._18_jun;

/**
 * Check if Binary Tree is Binary Search Tree
 *
 * @author ranjeet
 */
public class CheckBT {

    private static class Node {

        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(0);
        root.left.left = new Node(-1);
        root.left.right = new Node(21);

        root.right = new Node(25);
        root.right.left = new Node(16);
        root.right.right = new Node(32);

        CheckBT checkBT = new CheckBT();

        System.out.println(checkBT.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /*
    Root node.data must lies between min and max
     */
    public boolean isBST(Node root, int min, int max) {

        //base condition
        if (root == null) {
            return true;

        }

        //root data not lies between min and max
        if (root.data < min || root.data > max) {
            return false;

        }

        boolean isLeftBST = true;
        boolean isRightBST = true;
        if (root.left != null) {

            isLeftBST = isBST(root.left, min, root.data);
        }

        if (root.right != null) {

            isRightBST = isBST(root.right, root.data, max);
        }

        return isLeftBST && isRightBST;

    }

}
