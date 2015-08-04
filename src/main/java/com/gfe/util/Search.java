package com.gfe.util;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

public class Search {
    public static <T> Iterator<T> breadthFirstIterator(final T startingVertex,
            final Function<T, Collection<T>> getNeighbors) {
        final Set<T> visited = new HashSet<>();
        final Queue<T> queue = new LinkedList<>();

        queue.add(startingVertex);
        visited.add(startingVertex);

        return new Iterator<T>() {
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                final T next = queue.remove();
                for (final T neighbor : getNeighbors.apply(next)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
                return next;
            }
        };
    }

    public static <T> Iterator<T> depthFirstIterator(final T startingVertex,
            final Function<T, Collection<T>> getNeighbors) {
        final Set<T> visited = new HashSet<>();
        final Deque<Iterator<T>> stack = new LinkedList<>();

        stack.push(getNeighbors.apply(startingVertex).iterator());

        return new Iterator<T>() {
            private T next = startingVertex;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (next == null) {
                    throw new NoSuchElementException();
                }
                try {
                    visited.add(next);
                    return next;
                } finally {
                    advance();
                }
            }

            private void advance() {
                Iterator<T> neighbors = stack.peek();
                do {
                    while (!neighbors.hasNext()) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            next = null;
                            return;
                        }
                        neighbors = stack.peek();
                    }

                    next = neighbors.next();
                } while (visited.contains(next));
                stack.push(getNeighbors.apply(next).iterator());
            }
        };
    }

    public static <T> Collection<T> breadthFirstSearch(final T startingVertex, final T endingVertex,
            final Function<T, Collection<T>> getNeighbors) {
        final Queue<T> queue = new LinkedList<>();
        final Map<T, T> cameFrom = new HashMap<>();

        queue.add(startingVertex);
        cameFrom.put(startingVertex, null);

        boolean foundEnd = false;

        while (!queue.isEmpty()) {
            final T next = queue.remove();

            if (next == endingVertex) {
                foundEnd = true;
                break;
            }

            for (final T neighbor : getNeighbors.apply(next)) {
                if (!cameFrom.containsKey(neighbor)) {
                    queue.add(neighbor);
                    cameFrom.put(neighbor, next);
                }
            }
        }

        Deque<T> path = null;
        if (foundEnd) {
            // Follow back the path
            T current = endingVertex;
            path = new ArrayDeque<T>();
            path.add(current);
            while (current != startingVertex) {
                current = cameFrom.get(current);
                path.push(current);
            }
        }

        return path;
    }

    // http://www.redblobgames.com/pathfinding/a-star/introduction.html
    public static <T> Collection<T> weightedBreadthFirstSearch(final T start, final T goal,
            final Function<T, Collection<T>> getNeighbors) {
        final PriorityQueue<WeightedNode<T>> frontier = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.weight, o2.weight));
        final Map<WeightedNode<T>, WeightedNode<T>> cameFrom = new HashMap<>();

        final WeightedNode<T> startNode = new WeightedNode<T>(start, 0);
        frontier.add(startNode);
        cameFrom.put(startNode, null);
        final Map<WeightedNode<T>, Integer> costSoFar = new HashMap<>();
        costSoFar.put(startNode, 0);

        WeightedNode<T> endNode = null;

        while (!frontier.isEmpty()) {
            final WeightedNode<T> current = frontier.remove();

            if (current.vertex == goal) {
                endNode = current;
                break;
            }

            for (final T next : getNeighbors.apply(current.vertex)) {
                final int newCost = costSoFar.get(current) + 1; // TODO Get cost from path
                if (!costSoFar.containsKey(next) || newCost < costSoFar.get(next)) {
                    final WeightedNode<T> node = new WeightedNode<>(next, newCost);
                    costSoFar.put(node, newCost);
                    frontier.add(node);
                    cameFrom.put(node, current);
                }
            }
        }

        Deque<T> path = null;
        if (endNode != null) {
            // Follow back the path
            WeightedNode<T> current = endNode;
            path = new ArrayDeque<>();
            path.add(current.vertex);
            while (current != startNode) {
                current = cameFrom.get(current);
                path.push(current.vertex);
            }
        }

        return path;
    }

    private static class WeightedNode<T> {
        public T vertex;
        public int weight;

        public WeightedNode(final T vertex, final int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return vertex.toString() + ":" + weight;
        }
    }
}
