package future.fry.practice.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ranjeet
 */
public class CloneGraph {

// Clone an undirected graph. 
//Each node in the graph contains a label and a list of its neighbors.
    public static void main(String[] args) {

    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, node);

        node.neighbors.forEach((neighbor) -> {
            newNode.neighbors.add(neighbor);
        });

        return newNode;

    }

    private static class UndirectedGraphNode {

        int label;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

    }
}
