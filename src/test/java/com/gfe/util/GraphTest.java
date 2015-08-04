package com.gfe.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {
    @Test
    public void testSingleEdgeGraph() {
        final Graph<Integer> graph = new SingleEdgeGraph<>();

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertFalse(graph.createPath(1, 2));
        assertEquals(1, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testSingleEdgeDigraph() {
        final Graph<Integer> graph = new SingleEdgeDigraph<>();

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertTrue(graph.getChildren(2).isEmpty());

        assertFalse(graph.createPath(1, 2));
        assertEquals(1, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testMultiEdgeGraph() {
        final Graph<Integer> graph = new MultiEdgeGraph<>();

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testMultiEdgeDigraph() {
        final Graph<Integer> graph = new MultiEdgeDigraph<>();

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testSingleEdgeWeightedGraph() {
        final WeightedGraph<Integer, Boolean> graph = new SingleEdgeWeightedGraph<>(false);

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertFalse(graph.createPath(1, 2));
        assertEquals(1, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testSingleEdgeWeightedDigraph() {
        final WeightedGraph<Integer, Boolean> graph = new SingleEdgeWeightedDigraph<>(false);

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertTrue(graph.getChildren(2).isEmpty());

        assertFalse(graph.createPath(1, 2));
        assertEquals(1, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testMultiEdgeWeightedGraph() {
        final WeightedGraph<Integer, Boolean> graph = new MultiEdgeWeightedGraph<>(false);

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(1, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertFalse(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.getChildren(2).size());
        assertEquals(1, graph.getChildren(2).iterator().next().intValue());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }

    @Test
    public void testMultiEdgeWeightedDigraph() {
        final WeightedGraph<Integer, Boolean> graph = new MultiEdgeWeightedDigraph<>(false);

        assertEquals(0, graph.size());

        assertTrue(graph.add(1));
        assertFalse(graph.add(1));
        assertEquals(1, graph.size());

        assertTrue(graph.getChildren(1).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.size());
        assertFalse(graph.getChildren(1).isEmpty());
        assertEquals(1, graph.getChildren(1).size());
        assertEquals(2, graph.getChildren(1).iterator().next().intValue());
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.createPath(1, 2));
        assertEquals(2, graph.getChildren(1).size());

        assertTrue(graph.createPath(2, 3));
        assertEquals(3, graph.verticies().size());

        assertTrue(graph.removePath(2, 3));
        assertTrue(graph.getChildren(2).isEmpty());

        assertTrue(graph.remove(1));
        assertTrue(graph.getChildren(2).isEmpty());
        assertEquals(2, graph.size());
    }
}
