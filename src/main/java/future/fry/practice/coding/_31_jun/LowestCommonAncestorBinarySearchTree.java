package future.fry.practice.coding._31_jun;

import java.util.List;

/**
 * Lowest Common Ancestor in a Binary Search Tree.
 *
 * @author ranjeet
 */
public class LowestCommonAncestorBinarySearchTree {

    /*
    
    Given values of two nodes in a Binary Search Tree, 
    write a Java program to find the Lowest Common Ancestor (LCA). 
    You may assume that both the values exist in the tree.
     */
    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

//        List<Node> pathsI = new ArrayList<>();
//
//        getPath(root, 7, pathsI);
//
//        pathsI.stream().map(s -> s.data).forEach(out::println);
//
//        pathsI = new ArrayList<>();
//
//        getPath(root, 6, pathsI);
//
//        pathsI.stream().map(s -> s.data).forEach(out::println);
        System.out.println(lcaBST(root, 5, 7).data);

    }

    private static Node lcaBST(Node root, int n1, int n2) {

        if (null == root) {
            return null;
        }

        //if both n1 and n2 less than root, then LCA lies in left
        if (n1 < root.data && n2 < root.data) {

            return lcaBST(root.left, n1, n2);
        }

        // if both n1 and n2 grt than root, then LCA lies in right.
        if (n1 > root.data && n2 > root.data) {
            return lcaBST(root.right, n1, n2);
        }
        
        //if 
        
        return root;

    }

    private static boolean getPath(Node root, int i, List<Node> paths) {

        if (null == root) {
            return false;
        }

        if (root.data == i) {

            paths.add(root);
            return true;
        }

        boolean isLeftPath = false, isRightPath = false;
        if (root.data > i) {
            // go left
            isLeftPath = getPath(root.left, i, paths);
        } else {
            //go right
            isRightPath = getPath(root.right, i, paths);
        }

        if (isLeftPath || isRightPath) {
            paths.add(root);
            return true;
        }

        return false;

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
