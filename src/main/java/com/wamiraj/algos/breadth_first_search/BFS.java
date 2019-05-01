package com.wamiraj.algos.breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void navigate(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            System.out.println("current vertex -> " + currentVertex);

            for (Vertex v : currentVertex.getNeighbourVertextList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
