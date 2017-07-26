package future.fry.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ranjeet
 */
public class LevelAnagramTree {

    /*
    if each of their levels are anagrams of each other or not
     */
    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        //
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
        //

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        //
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        
        LevelAnagramTree anagramTree = new LevelAnagramTree();
        System.out.println(anagramTree.isAllLevelAnagrams(root1, root2));

    }

    private boolean isAllLevelAnagrams(Node root1, Node root2) {

        if (root2 == null || root1 == null) {
            return false;
        }

        //traverse level by level and check if level is angram
        Queue<Node> nodes1 = new LinkedList<>();
        nodes1.add(root1);

        Stack<Node> nodes2 = new Stack<>();
        nodes2.add(root2);

        while (!nodes1.isEmpty() && !nodes2.isEmpty()) {

            Node childNode1 = nodes1.poll();
            Node childNode2 = nodes2.pop();

            if (childNode1.data != childNode2.data) {
                return false;
            }

            if (childNode1.left != null) {
                nodes1.add(childNode1.left);
            }

            if (childNode1.right != null) {
                nodes1.add(childNode1.right);
            }

            if (childNode2.left != null) {
                nodes2.add(childNode2.left);
            }

            if (childNode2.right != null) {
                nodes2.add(childNode2.right);
            }

        }

        return !(!nodes1.isEmpty() || !nodes2.isEmpty());
    }

}
