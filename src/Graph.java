/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author yuval.melamed
 * @param <T> type of vertex
 */
public class Graph<T> {

    private final HashSet<T> vertexes;
    private final HashSet<Edge<T>> edges;

    public Graph() {
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
    }

    public Graph(Collection<T> vertexes, Collection<Edge<T>> edges) throws
            DuplicateVertexException, DuplicateEdgeException,
            NoSuchVertexException {
        this.vertexes = new HashSet<>(vertexes);
        this.edges = new HashSet<>(edges);

        if (vertexes.size() > this.vertexes.size()) {
            throw new DuplicateVertexException();
        }

        if (edges.size() > this.edges.size()) {
            throw new DuplicateEdgeException();
        }

        for (Edge<T> edge : edges) {
            if (!isValidEdge(edge)) {
                throw new NoSuchVertexException();
            }
        }
    }

    private boolean isValidEdge(Edge<T> edge) {
        return vertexExists(edge.getFromV()) && vertexExists(edge.getToV());
    }

    public void addVertex(T vertex) throws DuplicateVertexException {
        if (!getVertexes().add(vertex)) {
            throw new DuplicateVertexException();
        }
    }

    public void removeVertex(T vertex) throws NoSuchVertexException {
        if (!getVertexes().remove(vertex)) {
            throw new NoSuchVertexException();
        }
    }

    public void addEdge(Edge<T> edge) throws
            NoSuchVertexException, DuplicateEdgeException {
        if (!isValidEdge(edge)) {
            throw new NoSuchVertexException();
        }
        if (!getEdges().add(edge)) {
            throw new DuplicateEdgeException();
        }
    }

    public void removeEdge(Edge<T> edge) throws NoSuchEdgeException {
        if (!getEdges().remove(edge)) {
            throw new NoSuchEdgeException();
        }
    }

    public boolean vertexExists(T vertex) {
        return getVertexes().contains(vertex);
    }

    public boolean edgeExists(Edge<T> edge) {
        return getEdges().contains(edge);
    }

    public HashSet<T> getVertexes() {
        return vertexes;
    }

    public HashSet<Edge<T>> getEdges() {
        return edges;
    }
}
