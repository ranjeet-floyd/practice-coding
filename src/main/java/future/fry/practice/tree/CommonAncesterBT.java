package future.fry.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ranjeet
 */
public class CommonAncesterBT {

    /*
    Given a binary tree (not a binary search tree) and two values say n1 and n2,
    write a program to find the least common ancestor.
     */
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        //
        root.right.left = new Node(6);
        root.right.right = new Node(7);

//        System.out.println(commonAncester(root, new Node(4), new Node(7)));
        System.out.println(commonAncesterNode(root, new Node(4), new Node(7)));

    }

    /*
    Find all parents of n1 and n2 and return first match parent as result.
     */
    private static Node commonAncester(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        //both are same node
        if (n1.data == n2.data) {
            return n1;
        }

        List<Node> parentNodes_n1 = new ArrayList<>();
        List<Node> parentNodes_n2 = new ArrayList<>();

        parentNodes(root, n1, parentNodes_n1);
        parentNodes(root, n2, parentNodes_n2);

        Collections.reverse(parentNodes_n2);
        Collections.reverse(parentNodes_n1);

        return parentNodes_n1.stream().filter(s -> parentNodes_n2.contains(s)).findFirst().get();
        
//        parentNodes_n1.stream().
    }

    private static boolean parentNodes(Node root, Node n1, List<Node> parents_n1) {

        if (root == null) {
            return false;
        }

        if (n1.data == root.data) {
            return true;
        }

        boolean left = parentNodes(root.left, n1, parents_n1);
        boolean right = parentNodes(root.right, n1, parents_n1);

        if (left || right) {
            parents_n1.add(root);
        }

        if (left) {
            parents_n1.add(root.left);
        }

        if (right) {
            parents_n1.add(root.right);
        }

        return left || right;

    }

    private static Node commonAncesterNode(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        Node left = commonAncesterNode(root.left, n1, n2);
        Node right = commonAncesterNode(root.right, n1, n2);

        //if both key return non-null then one key is present in left and other in right.
        if (left != null && right != null) {
            return root;
        }


        return left == null ? right : left;
    }

}
