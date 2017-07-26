package future.fry.practice.tree;

/**
 *
 * @author ranjeet
 */
public class LCABST {

    /*
    Given values of two values n1 and n2 in a Binary Search Tree, 
    find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.
     */
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        /*
        *LCA of 10 and 14 is 12
        *LCA of 14 and 8 is 8
        *LCA of 10 and 22 is 20
         */
        System.out.println(LCA(root, new Node(4), new Node(14)));
    }

    private static Node LCA(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        //go left
        if (n1.data < root.data && n2.data < root.data) {
            return LCA(root.left, n1, n2);
        } //go right
        if (n1.data > root.data && n2.data > root.data) {
            return LCA(root.right, n1, n2);

        }

        return root;
    }

}
