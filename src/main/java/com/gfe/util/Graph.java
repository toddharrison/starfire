package com.gfe.util;

import java.util.Collection;
import java.util.Set;

public interface Graph<V> {
    boolean add(final V vertex);

    boolean remove(final V vertex);

    Set<V> verticies();

    int size();

    Collection<V> getChildren(final V vertex);

    boolean createPath(final V fromVertex, final V toVertex);

    boolean removePath(final V fromVertex, final V toVertex);
}
