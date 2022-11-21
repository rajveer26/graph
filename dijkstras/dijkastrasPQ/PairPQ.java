package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.Comparator;

public class PairPQ
{
    private int node;
    private int weight;

    PairPQ(int node, int weight)
    {
        this.node=node;
        this.weight=weight;
    }


    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    @Override

    public String toString()
    {
        return node + "," + weight;
    }
}
