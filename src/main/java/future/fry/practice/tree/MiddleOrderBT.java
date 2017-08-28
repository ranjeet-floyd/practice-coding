package future.fry.practice.tree;

/**
 *
 * @author ranjeet
 */
public class MiddleOrderBT {

    /*
    Print middle level of perfect binary tree without finding height
     */
    public static void main(String[] args) {

        /*
        Given a perfect binary tree, print nodes of middle level without computing its height. 
        A perfect binary tree is a binary tree in which 
        all interior nodes have two children and all leaves have the same depth or same level.
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        MiddleOrderBT orderBT = new MiddleOrderBT();
        orderBT.printMiddleOrder(root, root);

    }
//move a slow pointer by 1 and a fast pointer by 2. When fast reaches end..slow pointer will be at mid point.

    private void printMiddleOrder(Node slow, Node fast) {

        //base case
        if (fast == null || slow == null) {
            return;
        }

        //fast node reached leaf .. print slow node
        if (fast.left == null && fast.right == null) {

            System.out.println(slow.data + " ");
            return;

        }

        //recursivly call left and right
        printMiddleOrder(slow.left, fast.left.left);
        printMiddleOrder(slow.right, fast.right.right);

    }

}
