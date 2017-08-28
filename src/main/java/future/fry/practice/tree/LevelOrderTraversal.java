package future.fry.practice.tree;

import java.util.Stack;

/**
 * Level order traversal in spiral form
 *
 * @author ranjeet
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        /**
         * Write a function to print spiral order traversal of a tree. For below
         * tree, function should print 1, 2, 3, 4, 5, 6, 7.
         *
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //left
        root.left.left = new Node(7);
        root.left.right = new Node(6);

        //right
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        
        LevelOrderTraversal lot = new LevelOrderTraversal();
        lot.printSpiral(root);

    }

    private void printSpiral(Node root) {
        if (root == null) {
            return;
        }

        //create two stack for alternate storage of levels
        Stack<Node> rlStack = new Stack<>();
        Stack<Node> lrStack = new Stack<>();

        //push first node to right to left stack
        rlStack.push(root);

        while (!rlStack.isEmpty() || !lrStack.isEmpty()) {

            //print nodes of current level from s1 and push nodes of next level to s2
            while (!rlStack.isEmpty()) {
                Node tmp = rlStack.pop();
                System.out.print(tmp.data + " ");

                //push right first then left
                if (tmp.right != null) {
                    lrStack.push(tmp.right);
                }
                if (tmp.left != null) {
                    lrStack.push(tmp.left);

                }
            }
            //print node of lrStack  and push next level to rlStack
            while (!lrStack.isEmpty()) {

                Node tmp = lrStack.pop();
                System.out.print(tmp.data + " ");

                //push left first then right
                if (tmp.left != null) {
                    rlStack.push(tmp.left);
                }
                if (tmp.right != null) {
                    rlStack.push(tmp.right);
                }
            }
        }

    }

}
