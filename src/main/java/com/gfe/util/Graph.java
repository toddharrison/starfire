package com.gfe.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
    private final Map<V, List<Path<V>>> verticies;

    public Graph() {
        verticies = new HashMap<>();
    }

    public boolean add(final V vertex) {
        boolean added = false;
        if (!verticies.containsKey(vertex)) {
            verticies.put(vertex, new ArrayList<>());
            added = true;
        }
        return added;
    }

    public boolean remove(final V vertex) {
        boolean removed = false;
        if (verticies.containsKey(vertex)) {
            verticies.remove(vertex);
            for (final List<Path<V>> paths : verticies.values()) {
                for (int i = paths.size() - 1; i >= 0; i--) {
                    if (paths.get(i).toVertex == vertex) {
                        paths.remove(i);
                    }
                }
            }
            removed = true;
        }
        return removed;
    }

    public Set<V> verticies() {
        return verticies.keySet();
    }

    public int size() {
        return verticies.size();
    }

    public List<Path<V>> getPaths(final V vertex) {
        return verticies.get(vertex);
    }

    public List<V> getChildren(final V vertex) {
        final List<V> children = new ArrayList<>();
        for (final Path<V> path : verticies.get(vertex)) {
            children.add(path.getToVertex());
        }
        return children;
    }

    public Path<V> createPath(final V fromVertex, final V toVertex) {
        add(fromVertex);
        add(toVertex);
        final Path<V> path = new Path<>(fromVertex, toVertex);
        verticies.get(fromVertex).add(path);
        return path;
    }

    public boolean removePath(final Path<V> path) {
        boolean removed = false;
        final List<Path<V>> paths = verticies.get(path.fromVertex);
        if (paths != null) {
            removed = verticies.get(path.fromVertex).remove(path);
        }
        return removed;
    }

    @Override
    public String toString() {
        return verticies.toString();
    }

    public static class Path<V> {
        private final V fromVertex;
        private final V toVertex;

        public Path(final V fromVertex, final V toVertex) {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
        }

        public V getFromVertex() {
            return fromVertex;
        }

        public V getToVertex() {
            return toVertex;
        }

        @Override
        public String toString() {
            return fromVertex + " -> " + toVertex;
        }
    }
}
