package com.gfe.util;

import java.util.Collection;

public interface WeightedGraph<V, E> extends Graph<V> {
    E getDefaultEdge();

    Collection<Edge<V, E>> getEdges(final V vertex);

    boolean createPath(final V fromVertex, final E edge, final V toVertex);

    boolean removePath(final Edge<V, E> edge);
}
