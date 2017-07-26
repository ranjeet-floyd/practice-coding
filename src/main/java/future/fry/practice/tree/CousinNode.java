package future.fry.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ranjeet
 */
public class CousinNode {

    /*
    Given a tree, print all cousins of node that is given as input.
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
        CousinNode cousinNode = new CousinNode();
        Queue<Node> cousins = cousinNode.getCousinNodes(root, new Node(4));
        cousins.stream().forEach(System.out::println);
    }

    //return cousin node for given node
    private Queue<Node> getCousinNodes(Node root, Node node) {

        if (root == null || node == null) {

            return null;
        }

        Queue<Node> queueNodes = new LinkedList<>();
        root.level = 0;
        queueNodes.add(root);
        int level = 0;
        while (!queueNodes.isEmpty()) {
            Node childNode = queueNodes.poll();
            if (childNode.data == node.data) {
                queueNodes.removeIf(q -> q.level != childNode.level);
                return queueNodes; //if node found ..next level nodes are  cousins 
            }
            if (childNode.left != null) {
                childNode.left.level = childNode.level + 1;
                queueNodes.add(childNode.left);

            }

            if (childNode.right != null) {
                childNode.right.level = childNode.level + 1;
                queueNodes.add(childNode.right);
            }
            level++;

        }

        return null;

    }

}
