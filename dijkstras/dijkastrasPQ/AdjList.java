package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjList
{
    static Scanner sc=new Scanner(System.in);
    AdjList()
    {
        super();
    }

    public static ArrayList<ArrayList<PairPQ>> adjDis(int m, int n)
    {
        ArrayList<ArrayList<PairPQ>> al= new ArrayList<ArrayList<PairPQ>>();
        for(int i=0;i<=n;i++)
        {
            al.add(i,new ArrayList<PairPQ>());
        }
        for (int i=0;i<m;i++)
        {
            System.out.println("Enter u");
            int u=sc.nextInt();
            System.out.println("Enter v with weight");
            int v=sc.nextInt();
            int w=sc.nextInt();
            al.get(u).add(new PairPQ(v,w));
            al.get(v).add(new PairPQ(u,w));
        }
        int i=0;
        for (ArrayList<PairPQ> al1 :al)
        {
            System.out.println("\nAdjacency list of vertex "
                    + i);
            System.out.print("head");
            i++;
            for (PairPQ al2: al1)
            {
                System.out.print(" -> "+al2);
            }
            System.out.println();
        }
        System.out.println(al);
        return al;
    }

    public static void main(String[] args) {
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");

        int m=sc.nextInt();
        AdjList.adjDis(m,n);
    }
}
