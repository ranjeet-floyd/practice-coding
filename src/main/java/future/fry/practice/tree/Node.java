package future.fry.practice.tree;

/**
 *
 * @author ranjeet
 */
public class Node {

    int data;
    int level;
    Node left = null, right = null;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", level=" + level + '}';
    }


}
