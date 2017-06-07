package future.fry.practice.coding._30_may;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author ranjeet
 */
public class LowestCommonAncestorBinaryTree {


    /*
    Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.
     */
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> paths = new ArrayList<>();

        getPath(root, 5, paths);

        for (Integer path : paths) {
            System.out.println(path);
        }

        Stack<Integer> stack = new Stack<>();
        getPath(root, 5, stack);

        stack.forEach(i -> System.out.println(i));

    }

    public static int lowestCommonAncestor(Node root) {
        return 1;
    }

    public static boolean getPath(Node root, int data, List<Integer> paths) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            paths.add(root.data);
            return true;
        }
        boolean left_check = getPath(root.left, data, paths);
        boolean right_Check = getPath(root.right, data, paths);
        if (left_check || right_Check) {
            paths.add(root.data);
            return true;
        }
        return false;
    }

    public static void getPath(Node root, int data, Stack<Integer> paths) {
        if (root == null) {
            return;
        }

        paths.push(root.data);
        if (root.data == data) {
            paths.push(root.data);
            return;
        }

        if (root.left == null && root.right == null) {
            if (!paths.empty()) {
                paths.pop();
            }
            return;
        }
        getPath(root.left, data, paths);
        getPath(root.right, data, paths);
        if (!paths.empty()) {
            paths.pop();
        }
    }

    private static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
}
