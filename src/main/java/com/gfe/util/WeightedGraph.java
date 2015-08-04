package com.gfe.util;

import java.util.Collection;

public interface WeightedGraph<V, E> extends Graph<V> {
    E getDefaultEdge();

    Collection<Edge<V, E>> getEdges(final V vertex);

    boolean createPath(final V fromVertex, final E edge, final V toVertex);

    boolean removePath(final Edge<V, E> edge);

    public static class Edge<V, E> {
        private final V fromVertex;
        private final E edge;
        private final V toVertex;

        public Edge(final V fromVertex, final E edge, final V toVertex) {
            this.fromVertex = fromVertex;
            this.edge = edge;
            this.toVertex = toVertex;
        }

        public V getFromVertex() {
            return fromVertex;
        }

        public E getEdge() {
            return edge;
        }

        public V getToVertex() {
            return toVertex;
        }

        @Override
        public String toString() {
            return fromVertex + " -> " + edge + " -> " + toVertex;
        }

        @Override
        public boolean equals(final Object obj) {
            boolean equal = this == obj;
            if (obj != null && obj instanceof Edge) {
                final Edge<?, ?> e = (Edge<?, ?>) obj;
                equal = e.getFromVertex().equals(fromVertex) && e.getEdge().equals(edge)
                        && e.getToVertex().equals(toVertex);
            }
            return equal;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (edge == null ? 0 : edge.hashCode());
            result = prime * result + (fromVertex == null ? 0 : fromVertex.hashCode());
            result = prime * result + (toVertex == null ? 0 : toVertex.hashCode());
            return result;
        }
    }
}
