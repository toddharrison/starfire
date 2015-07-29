package com.gfe.util;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.gfe.util.Digraph.Path;

public class DigraphTest {
    @Test
    public void testAddAndRemove() {
        final Digraph<Integer, Boolean> graph = new Digraph<>();

        assertTrue(graph.add(1));
        assertNotNull(graph.createPath(1, false, 2));
        final Path<Integer, Boolean> path = graph.createPath(1, true, 3);
        assertNotNull(path);
        assertNotNull(graph.createPath(1, false, 4));
        assertEquals(4, graph.size());
        assertEquals(3, graph.getPaths(1).size());

        graph.removePath(path);
        assertEquals(2, graph.getPaths(1).size());

        graph.remove(3);
        assertEquals(3, graph.size());

        graph.remove(4);
        assertEquals(1, graph.getPaths(1).size());
        assertEquals(2, graph.size());
    }

    @Test
    public void testIterateBreadth() {
        final Digraph<Integer, Boolean> graph = new Digraph<>();
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
        final Digraph<Integer, Boolean> graph = new Digraph<>();
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
        final Digraph<Integer, Boolean> graph = new Digraph<>();
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

        final Iterator<Integer> iterator = Search
                .breadthFirstSearch(1, 6, t -> graph.getChildren(t)).iterator();
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testWeightedSearchBreadth() {
        final Digraph<Integer, Boolean> graph = new Digraph<>();
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

        final Iterator<Integer> iterator = Search
                .weightedBreadthFirstSearch(1, 6, v -> graph.getChildren(v), (final Integer v) -> 1)
                .iterator();
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(6, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
