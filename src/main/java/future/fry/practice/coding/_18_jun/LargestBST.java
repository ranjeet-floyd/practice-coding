package future.fry.practice.coding._18_jun;

/**
 * Given a binary tree find the largest binary search tree.
 *
 * @author ranjeet
 */
public class LargestBST {

    public static class Node {

        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }

    }

    public static class Info {

        boolean isBST;
        int size;
        int maxLeft;
        int minRight;

        public Info() {
            isBST = false;
            size = 0;
            maxLeft = 0;
            minRight = 0;
        }

        public Info(boolean isBST, int size, int maxLeft, int minRight) {
            this.isBST = isBST;
            this.size = size;
            this.maxLeft = maxLeft;
            this.minRight = minRight;
        }

    }

    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.right = new Node(4);

        rootNode.left = new Node(2);

        rootNode.left.left = new Node(1);
        rootNode.left.right = new Node(3);
        LargestBST bST = new LargestBST();

//        System.out.println(bST.largestBST(rootNode));
        Node rootNode1 = new Node(50);
        rootNode1.left = new Node(30);
        rootNode1.right = new Node(60);

        rootNode1.left.left = new Node(5);
        rootNode1.left.right = new Node(20);

        rootNode1.right.left = new Node(45);
        rootNode1.right.right = new Node(70);

        rootNode1.right.right.left = new Node(65);
        rootNode1.right.right.right = new Node(80);

        System.out.println(bST.largestBST(rootNode1).size);

    }

    /*
    check and validate recusively every node as BST.
     */
    public Info largestBST(Node rootNode) {

        //base condition
        if (rootNode.left == null && rootNode.right == null) {
            return new Info(true, 1, rootNode.data, rootNode.data);
        }

        Info leftInfo = new Info();
        Info rightInfo = new Info();
        //go left and check
        if (rootNode.left != null) {
            leftInfo = largestBST(rootNode.left);

        }
        if (rootNode.right != null) {
            rightInfo = largestBST(rootNode.right);
        }

        //is Node is BST and update info
        if (leftInfo.isBST && rightInfo.isBST) {
            if (rootNode.data >= leftInfo.maxLeft && rootNode.data <= rightInfo.minRight) {
                //valid BST 
                return new Info(true, leftInfo.size + rightInfo.size + 1, leftInfo.maxLeft, rightInfo.minRight);
            }
        }

        return new Info(false, Math.max(leftInfo.size, rightInfo.size), 0, 0);

    }

}
