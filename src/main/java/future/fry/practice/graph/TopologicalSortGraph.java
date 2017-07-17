package future.fry.practice.graph;

import future.fry.practice.graph.Graph.Vertex;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Generate topologically sorted order for directed acyclic graph.
 *
 * @author ranjeet
 */
public class TopologicalSortGraph<T> {

    /* * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
    
     */
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);

        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        TopologicalSortGraph<Integer> sortGraph = new TopologicalSortGraph<>();
        Stack<Graph.Vertex<Integer>> stack = sortGraph.topologicalSort(graph);

        while (!stack.isEmpty()) {

            long top = stack.pop().getId();
            System.out.println(top);
        }

    }

    private Stack<Vertex<T>> topologicalSort(Graph<T> graph) {
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visited = new HashSet<>();
        // for each vertex iterate and add to stack if no child left to visit

        for (Vertex<T> vertex : graph.getAllVertex()) {

            //skip
            if (visited.contains(vertex)) {
                continue;
            }

            this.topologicalSortUtils(vertex, stack, visited);

        }

        return stack;

    }

    private void topologicalSortUtils(Vertex<T> vertex, Stack<Vertex<T>> stack, Set<Vertex<T>> visited) {
        visited.add(vertex);
        //visit all adjacent children as DFS
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (visited.contains(childVertex)) {
                continue;
            }
            topologicalSortUtils(childVertex, stack, visited);
        }

        stack.push(vertex);
    }

}
