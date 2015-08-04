package com.gfe.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleEdgeWeightedGraph<V, E> implements WeightedGraph<V, E> {
    private final E defaultEdge;
    private final Map<V, Set<Edge<V, E>>> verticies;

    public SingleEdgeWeightedGraph(final E defaultEdge) {
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
            verticies.put(vertex, new HashSet<>());
            added = true;
        }
        return added;
    }

    @Override
    public boolean remove(final V vertex) {
        boolean removed = false;
        if (verticies.containsKey(vertex)) {
            verticies.remove(vertex);
            for (final Set<Edge<V, E>> edges : verticies.values()) {
                for (final Edge<V, E> edge : edges) {
                    if (edge.getToVertex().equals(vertex)) {
                        edges.remove(edge);
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
    public Set<V> getChildren(final V vertex) {
        final Set<V> children = new HashSet<>();
        for (final Edge<V, E> edge : verticies.get(vertex)) {
            children.add(edge.getToVertex());
        }
        return children;
    }

    @Override
    public Set<Edge<V, E>> getEdges(final V vertex) {
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
        return verticies.get(fromVertex).add(new Edge<V, E>(fromVertex, edge, toVertex))
                & verticies.get(toVertex).add(new Edge<V, E>(toVertex, edge, fromVertex));
    }

    @Override
    public boolean removePath(final V fromVertex, final V toVertex) {
        final Set<Edge<V, E>> fromEdges = verticies.get(fromVertex);
        for (final Edge<V, E> fromEdge : fromEdges) {
            if (fromEdge.getFromVertex().equals(fromVertex)
                    && fromEdge.getToVertex().equals(toVertex)) {
                fromEdges.remove(fromEdge);
            }
        }
        final Set<Edge<V, E>> toEdges = verticies.get(toVertex);
        for (final Edge<V, E> toEdge : toEdges) {
            if (toEdge.getFromVertex().equals(toVertex)
                    && toEdge.getToVertex().equals(fromVertex)) {
                toEdges.remove(toEdge);
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
