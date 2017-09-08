package future.fry.practice.amazon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 *
 * @author ranjeet
 */
public class BinaryTreeLevelOrderTraversal {

    /*
    Given a binary tree, return the level order 
    traversal of its nodes' values. (ie, from left to right, level by level).
     */
    public static void main(String[] args) {

        // For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        BinaryTreeLevelOrderTraversal levelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = levelOrderTraversal.getLevelOrderTraversal(root);

        result.stream().forEach(subResult -> {
            System.out.println(subResult.stream().map(i -> Integer.toString(i))
                    .collect(Collectors.joining(",")));
        });

    }

    private List<List<Integer>> getLevelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = Arrays.asList(root.val);
        result.add(temp);
        while (!queue.isEmpty()) {
            Queue<Node> currentLevel = new LinkedList<>();
            List<Integer> subResult = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node currNodel = queue.poll();
                if (currNodel.left != null) {
                    currentLevel.add(currNodel.left);
                    subResult.add(currNodel.left.val);
                }
                if (currNodel.right != null) {
                    currentLevel.add(currNodel.right);
                    subResult.add(currNodel.right.val);
                }

            }
            if (!subResult.isEmpty()) {
                result.add(subResult);
            }
            queue = currentLevel;
        }

        return result;

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
