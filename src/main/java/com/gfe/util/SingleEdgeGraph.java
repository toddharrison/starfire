package com.gfe.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleEdgeGraph<V> implements Graph<V> {
    private final Map<V, Set<V>> verticies;

    public SingleEdgeGraph() {
        verticies = new HashMap<>();
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
            for (final Set<V> paths : verticies.values()) {
                paths.remove(vertex);
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
        return verticies.get(vertex);
    }

    @Override
    public boolean createPath(final V fromVertex, final V toVertex) {
        add(fromVertex);
        add(toVertex);
        return verticies.get(fromVertex).add(toVertex) & verticies.get(toVertex).add(fromVertex);
    }

    @Override
    public boolean removePath(final V fromVertex, final V toVertex) {
        return verticies.get(fromVertex).remove(toVertex)
                & verticies.get(toVertex).remove(fromVertex);
    }

    @Override
    public String toString() {
        return verticies.toString();
    }
}
