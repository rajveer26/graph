package com.java.algoveer.graph.bellmanFord;

import java.util.*;


class Main
{
    static void bellmanFord(ArrayList<NodeBM> edges, int N, int src)
    {
        int dist[] = new int[N+1];
        for(int i = 0;i<=N;i++) dist[i] = 10000000;

        dist[src] = 0;

        for(int i = 0;i<=N-1;i++) {
            for(NodeBM node : edges) {
                if(dist[node.getU()]+node.getWt()<dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWt();
                }
            }
        }

        int fl = 0;
        for(NodeBM node: edges) {
            if(dist[node.getU()] +node.getWt() < dist[node.getV()]) {
                fl = 1;
                System.out.println("Negative Cycle");
                break;
            }
        }

        if(fl == 0) {
            for(int i = 0;i<N;i++) {
                System.out.print(  dist[i]+" ");
            }
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<NodeBM> adj = new ArrayList<NodeBM>();


        adj.add(new NodeBM(3, 2, 6));
        adj.add(new NodeBM(5, 3, 1));
        adj.add(new NodeBM(0, 1, 5));
        adj.add(new NodeBM(1, 5, -3));
        adj.add(new NodeBM(1, 2, -2));
        adj.add(new NodeBM(3, 4, -2));
        adj.add(new NodeBM(2, 4, 3));


        //Main obj = new Main();
        Main.bellmanFord(adj, n, 0);

    }
}
