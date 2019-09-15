package com.wamiraj.algos.depth_first_search;

import com.wamiraj.algos.breadth_first_search.BFS;
import com.wamiraj.algos.breadth_first_search.Vertex;

public class App {
    public static void main(String[] args) {
        BFS bfs = new BFS();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);


        vertex1.addNeighbour(vertex2);
        vertex1.addNeighbour(vertex3);
        vertex1.addNeighbour(vertex4);
        vertex2.addNeighbour(vertex1);
        vertex2.addNeighbour(vertex5);
        vertex3.addNeighbour(vertex4);
        vertex4.addNeighbour(vertex3);

        bfs.navigate(vertex1);
    }
}
