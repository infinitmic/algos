package com.wamiraj.algos.breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int data;
    private boolean visited;
    private List<Vertex> neighbourVertextList;

    public Vertex(int data){
        this.data = data;
        visited = false;
        neighbourVertextList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Vertex vertex) {
        neighbourVertextList.add(vertex);
    }

    public List<Vertex> getNeighbourVertextList() {
        return neighbourVertextList;
    }

    @Override
    public String toString() {
        return " " + data;
    }
}
