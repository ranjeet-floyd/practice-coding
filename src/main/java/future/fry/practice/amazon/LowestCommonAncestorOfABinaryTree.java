package future.fry.practice.amazon;

/**
 *
 * @author ranjeet
 */
public class LowestCommonAncestorOfABinaryTree {

    /*
     Given a binary tree, find the lowest common ancestor (LCA) 
    of two given nodes in the tree.
     */
    public static void main(String[] args) {

        // _______3______
//        /              \
//     ___5__          ___1__
//    /      \        /      \
//    6      _2       0       8
//          /  \
//          7   4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
//Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself 
//according to the LCA definition.
    }

    private Node lowestCommonAncester(Node root, Node p, Node q) {

        //base condition
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lowestCommonAncester(root.left, p, q);
        Node right = lowestCommonAncester(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;

    }

    private static class Node {

        int val;
        Node left;
        Node right;

        public Node(int x) {
            val = x;
        }

    }
}
