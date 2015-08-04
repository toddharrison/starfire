package com.gfe.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiEdgeWeightedDigraph<V, E> implements WeightedGraph<V, E> {
    private final E defaultEdge;
    private final Map<V, List<Edge<V, E>>> verticies;

    public MultiEdgeWeightedDigraph(final E defaultEdge) {
        this.defaultEdge = defaultEdge;
        verticies = new HashMap<>();
    }

    @Override
    public E getDefaultEdge() {
        return defaultEdge;
    }

    @Override
    public boolean add(final V vertex) {
        boolean added = false;
        if (!verticies.containsKey(vertex)) {
            verticies.put(vertex, new ArrayList<>());
            added = true;
        }
        return added;
    }

    @Override
    public boolean remove(final V vertex) {
        boolean removed = false;
        if (verticies.containsKey(vertex)) {
            verticies.remove(vertex);
            for (final List<Edge<V, E>> edges : verticies.values()) {
                for (int i = edges.size() - 1; i >= 0; i--) {
                    final Edge<V, E> edge = edges.get(i);
                    if (edge.getToVertex().equals(vertex)) {
                        edges.remove(i);
                    }
                }
            }
            removed = true;
        }
        return removed;
    }

    @Override
    public Set<V> verticies() {
        return verticies.keySet();
    }

    @Override
    public int size() {
        return verticies.size();
    }

    @Override
    public List<V> getChildren(final V vertex) {
        final List<V> children = new ArrayList<>();
        for (final Edge<V, E> edge : verticies.get(vertex)) {
            children.add(edge.getToVertex());
        }
        return children;
    }

    @Override
    public List<Edge<V, E>> getEdges(final V vertex) {
        return verticies.get(vertex);
    }

    @Override
    public boolean createPath(final V fromVertex, final V toVertex) {
        return createPath(fromVertex, defaultEdge, toVertex);
    }

    @Override
    public boolean createPath(final V fromVertex, final E edge, final V toVertex) {
        add(fromVertex);
        add(toVertex);
        return verticies.get(fromVertex).add(new Edge<V, E>(fromVertex, edge, toVertex));
    }

    @Override
    public boolean removePath(final V fromVertex, final V toVertex) {
        final List<Edge<V, E>> fromEdges = verticies.get(fromVertex);
        for (int i = fromEdges.size() - 1; i >= 0; i--) {
            final Edge<V, E> fromEdge = fromEdges.get(i);
            if (fromEdge.getFromVertex().equals(fromVertex)
                    && fromEdge.getToVertex().equals(toVertex)) {
                fromEdges.remove(i);
            }
        }
        return true;
    }

    @Override
    public boolean removePath(final Edge<V, E> edge) {
        return getEdges(edge.getFromVertex()).remove(edge);
    }

    @Override
    public String toString() {
        return verticies.toString();
    }
}
