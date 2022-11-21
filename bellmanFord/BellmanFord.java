package com.java.algoveer.graph.bellmanFord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord
{
    BellmanFord()
    {
        super();
    }
    public static int[] bellman(int vertices, ArrayList<NodeBM> al, int src,int dest, int[] dist)
    {
        for(Integer di1: dist)
        {
            System.out.println(Arrays.toString(dist));
            break;
        }
        int N=vertices;
        int count=0;
       for(int i=0;i<=N-1;i++)
       {
           count++;
           for (NodeBM li: al)
           {
               if(dist[li.getU()] + li.getWt() < dist[li.getV()])
               {
                   dist[li.getV()] = dist[li.getU()] + li.getWt();
                   System.out.println(dist[li.getV()]);
               }
           }
       }
       boolean mark=true;
       for(NodeBM li:al)
       {
           if(dist[li.getU()]+li.getWt()<dist[li.getV()])
           {
               dist[li.getV()]= dist[li.getU()]+ li.getWt();
               mark=false;
               System.out.println("Negative cycle");
               break;
           }
       }
       if(mark==false)
       {
           return new int[]{-1};
       }
       System.out.println(count);
       return dist;
    }
    public static void traversebm(int vertices, ArrayList<NodeBM> al, int src, int dest)
    {
         int[] dist=new int[vertices+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        int[] d=bellman(vertices,al,src,dest,dist);
        for(Integer d1:d)
        {
            System.out.println(Arrays.toString(d));
            break;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int m=sc.nextInt();
        System.out.println("Enter edges");
        int n=sc.nextInt();
        ArrayList<NodeBM> l=AdjlistBM.adjBM(m,n);
        System.out.println("Enter starting node");
        int strt=sc.nextInt();
        System.out.println("Enter dest");
        int dest=sc.nextInt();
        BellmanFord.traversebm(m,l,strt,dest);
    }
}
