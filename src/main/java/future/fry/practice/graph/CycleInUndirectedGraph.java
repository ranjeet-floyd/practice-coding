package future.fry.practice.graph;

import future.fry.practice.graph.Graph.Vertex;
import java.util.HashSet;
import java.util.Set;

/**
 * Cycle in undirected graph using DFS and disjoint sets.
 *
 * x` * @author ranjeet
 */
public class CycleInUndirectedGraph<T> {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(false);
        graph.addEdge(1, 6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
//        graph.addEdge(4, 5);

        CycleInUndirectedGraph<String> cycleInUndirectedGraph = new CycleInUndirectedGraph<>();

        System.out.println(cycleInUndirectedGraph.isCyclic(graph));
    }

    private boolean isCyclic(Graph<T> graph) {
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                //skip
                continue;
            }

            boolean isCycle = isCyclicUtil(vertex, visited, null);
            if (isCycle) {
                return isCycle;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Vertex<T> parent) {

        visited.add(vertex);

        for (Vertex<T> adj : vertex.getAdjacentVertex()) {

            if (adj.equals(parent)) {
                //skip
                continue;
            }

            if (visited.contains(adj)) {

                return true;
            }
            visited.add(adj);

            boolean isCyclic = isCyclicUtil(adj, visited, vertex);
            if (isCyclic) {
                return true;
            }

        }

        return false;

    }

}
