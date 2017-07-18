package future.fry.practice.random;

/**
 * Check if two nodes are cousins in a Binary Tree
 *
 * @author ranjeet
 */
public class CousinBinaryTree {

    /*
     * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine
     * whether the two nodes are cousins of each other or not.
     *
     * Two nodes are cousins of each other if they are at same level and have
     * different parents.
     */
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.left = new Node(1);
        root.right.right = new Node(3);
        /*
        Say two node be 7 and 1, result is TRUE.
        Say two nodes are 3 and 5, result is FALSE.
        Say two nodes are 7 and 5, result is FALSE.
         */

        CousinBinaryTree cbt = new CousinBinaryTree();
//        cbt.isCousin(7, 1, root);
        cbt.isCousin(3, 5, root);
        cbt.isCousin(7, 5, root);
        cbt.isCousin(8, 10, root);

    }

    private void isCousin(int d1, int d2, Node root) {

        NodeInfo nodeInfo_7 = getNodeInfo(root, d1, 0, null);
        NodeInfo nodeInfo_1 = getNodeInfo(root, d2, 0, null);
        boolean isSameLevel = nodeInfo_7.level == nodeInfo_1.level;
        boolean isSameParent = nodeInfo_7.parent.equals(nodeInfo_1.parent);
        System.out.println(isSameLevel && !isSameParent);
    }

    private NodeInfo getNodeInfo(Node root, int d, int level, Node parent) {
        if (root == null) {
            return new NodeInfo(-1, null);
        }

        if (root.data == d) {
            return new NodeInfo(level, parent);
        }
        //search left
        NodeInfo leftLevel = getNodeInfo(root.left, d, level + 1, root);
        //if present return
        if (leftLevel.level > -1) {
            return leftLevel;
        }
        //else search right
        NodeInfo rightLevel = getNodeInfo(root.right, d, level + 1, root);

        if (rightLevel.level > -1) {
            return rightLevel;
        }

        return new NodeInfo(-1, null); //not found

    }

    private static class NodeInfo {

        int level;
        Node parent;

        public NodeInfo(int level, Node parent) {
            this.level = level;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "NodeInfo{" + "level=" + level + ", parent=" + parent.data + '}';
        }

    }

    private static class Node {

        int data;

        Node left = null, right = null;

        public Node(int id) {
            this.data = id;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + this.data;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            return this.data == other.data;
        }

    }
}
