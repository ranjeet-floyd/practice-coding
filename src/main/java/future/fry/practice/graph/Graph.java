package future.fry.practice.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author ranjeet
 */
class Graph<T> {
    
    private List<Edge<T>> edges;
    private Map<Long, Vertex<T>> allVertex;
    
    boolean isDirected = false;
    
    public Graph(boolean _isDirected) {
        this.isDirected = _isDirected;
        edges = new ArrayList<>();
        allVertex = new HashMap<>();
    }
    
    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
        
    }
    
    private void addEdge(long id1, long id2, int weight) {
        
        Vertex<T> v1;
        
        if (allVertex.containsKey(id1)) {
            v1 = allVertex.get(id1);
        } else {
            
            v1 = new Vertex<>(id1);
            allVertex.put(id1, v1);
            
        }
        
        Vertex<T> v2;
        
        if (allVertex.containsKey(id2)) {
            v2 = new Vertex<>(id2);
        } else {
            v2 = new Vertex<>(id2);
            allVertex.put(id2, v2);
        }
        
        Edge<T> edge = new Edge<>(v1, v2, weight, isDirected);
        
        edges.add(edge);
        v1.addAdjacentVertex(edge, v2);
        
        if (!isDirected) {
            v2.addAdjacentVertex(edge, v1);
        }
        
    }
    
    public void addVertex(Vertex<T> vertex) {
        
        if (allVertex.containsKey(vertex.getId())) {
            return;
        }
        
        allVertex.put(vertex.getId(), vertex);
        
    }
    
    public Vertex<T> addSingleVertex(long id) {
        
        if (allVertex.containsKey(id)) {
            return allVertex.get(id);
        }
        
        Vertex<T> v = new Vertex<>(id);
        allVertex.put(id, v);
        
        return v;
        
    }
    
    public Vertex<T> getVertex(long id) {
        return allVertex.get(id);
    }
    
    public List<Edge<T>> getAllEdges() {
        
        return edges;
    }
    
    public Collection<Vertex<T>> getAllVertex() {
        
        return allVertex.values();
    }
    
    public void setDataForVertex(long id, T data) {
        
        if (allVertex.containsKey(id)) {
            Vertex<T> v = allVertex.get(id);
            v.setData(data);
        }
    }
    
    static class Vertex<T> {
        
        private final long id;
        private T data;
        private final List<Edge<T>> edges = new ArrayList<>();
        private final List<Vertex<T>> adjacentVertex = new ArrayList<>();
        
        public Vertex(long id) {
            this.id = id;
        }
        
        public long getId() {
            return id;
        }
        
        public T getData() {
            return data;
        }
        
        public void setData(T data) {
            this.data = data;
        }
        
        public List<Edge<T>> getEdges() {
            return edges;
        }
        
        public List<Vertex<T>> getAdjacentVertex() {
            return adjacentVertex;
        }
        
        public int getDegree() {
            return edges.size();
        }
        
        public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
            edges.add(e);
            adjacentVertex.add(v);
            
        }
        
        @Override
        public String toString() {
            return "Vertex{" + "id=" + id + '}';
        }
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
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
            final Vertex<?> other = (Vertex<?>) obj;
            return this.id == other.id;
        }
        
    }
    
    static class Edge<T> {
        
        private boolean isDirected = false;
        private Vertex<T> vertex1;
        private Vertex<T> vertex2;
        private int weight;
        
        public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
        
        public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
        
        public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
            this.isDirected = isDirected;
        }
        
        public boolean isIsDirected() {
            return isDirected;
        }
        
        public Vertex<T> getVertex1() {
            return vertex1;
        }
        
        public Vertex<T> getVertex2() {
            return vertex2;
        }
        
        public int getWeight() {
            return weight;
        }
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 73 * hash + Objects.hashCode(this.vertex1);
            hash = 73 * hash + Objects.hashCode(this.vertex2);
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
            final Edge<?> other = (Edge<?>) obj;
            if (!Objects.equals(this.vertex1, other.vertex1)) {
                return false;
            }
            if (!Objects.equals(this.vertex2, other.vertex2)) {
                return false;
            }
            return true;
        }
        
        @Override
        public String toString() {
            return "Edge{" + "isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + '}';
        }
        
    }
    
}
