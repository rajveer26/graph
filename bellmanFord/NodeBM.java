package com.java.algoveer.graph.bellmanFord;

public class NodeBM {
    private int u, v, wt;

    NodeBM(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWt() {
        return wt;
    }

    public String toString() {
        return u + "," + v + "," + wt;
    }
}
