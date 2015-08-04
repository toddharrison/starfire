package com.gfe.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiEdgeDigraph<V> implements Graph<V> {
    private final Map<V, List<V>> verticies;

    public MultiEdgeDigraph() {
        verticies = new HashMap<>();
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
            for (final List<V> paths : verticies.values()) {
                for (int i = paths.size() - 1; i >= 0; i--) {
                    if (paths.get(i) == vertex) {
                        paths.remove(i);
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
        return verticies.get(vertex);
    }

    @Override
    public boolean createPath(final V fromVertex, final V toVertex) {
        add(fromVertex);
        add(toVertex);
        return verticies.get(fromVertex).add(toVertex);
    }

    @Override
    public boolean removePath(final V fromVertex, final V toVertex) {
        return verticies.get(fromVertex).remove(toVertex);
    }

    @Override
    public String toString() {
        return verticies.toString();
    }
}
