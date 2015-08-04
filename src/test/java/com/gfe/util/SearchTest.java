package com.gfe.util;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {
    private WeightedGraph<Integer, Boolean> graph;

    @Before
    public void init() {
        graph = new SingleEdgeWeightedDigraph<>(false);

        graph.add(1);
        graph.createPath(1, false, 2);
        graph.createPath(1, false, 3);
        graph.createPath(1, false, 4);

        graph.createPath(2, false, 5);
        graph.createPath(2, false, 6);

        graph.createPath(3, false, 7);
        graph.createPath(3, false, 8);

        graph.createPath(4, false, 9);
        graph.createPath(4, false, 10);
    }

    @Test
    public void testIterateBreadth() {
        final Iterator<Integer> iterator = Search.breadthFirstIterator(1,
                t -> graph.getChildren(t));
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());
        assertEquals(4, iterator.next().intValue());
        assertEquals(5, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertEquals(8, iterator.next().intValue());
        assertEquals(9, iterator.next().intValue());
        assertEquals(10, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIterateDepth() {
        final Iterator<Integer> iterator = Search.depthFirstIterator(1, t -> graph.getChildren(t));
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(5, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertEquals(8, iterator.next().intValue());
        assertEquals(4, iterator.next().intValue());
        assertEquals(9, iterator.next().intValue());
        assertEquals(10, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testSearchBreadth() {
        final Iterator<Integer> iterator = Search
                .breadthFirstSearch(1, 6, t -> graph.getChildren(t)).iterator();
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testWeightedSearchBreadth() {
        final Iterator<Integer> iterator = Search
                .weightedBreadthFirstSearch(1, 6, t -> graph.getChildren(t)).iterator();
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
