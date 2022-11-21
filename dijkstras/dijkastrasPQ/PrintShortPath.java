package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.*;

public class PrintShortPath
{
    PrintShortPath()
    {
        super();
    }

    public static void dijas(int vertices, ArrayList<ArrayList<PairPQ>> al, int[] parent, int[] distance,int strt,int dest,ArrayList<Integer> arl)
    {
        PriorityQueue<PairPQ> p=new PriorityQueue<PairPQ>(vertices,(node1,node2)->(node1.getWeight() < node2.getWeight()) ? -1:(node1.getWeight() > node2.getWeight()) ? 1:0);
        p.add(new PairPQ(strt,0));
        while (!p.isEmpty())
        {
            PairPQ vert=p.poll();

            for (PairPQ p1:al.get(vert.getNode()))
            {
                if(distance[vert.getNode()]+p1.getWeight()<distance[p1.getNode()])
                {
                    distance[p1.getNode()]=distance[vert.getNode()]+p1.getWeight();
                    parent[p1.getNode()]=vert.getNode();
                    p.add(new PairPQ(p1.getNode(), distance[p1.getNode()]));
                }
            }
        }

        while (parent[dest]!=dest)
        {
          arl.add(dest);
          dest=parent[dest];
        }
        arl.add(strt);
    }
    public static void trav(int vertices,ArrayList<ArrayList<PairPQ>> al, int strt,int dest)
    {
        int[] desti=new int[vertices+1];
        int[] parent=new int[vertices+1];
        Arrays.fill(desti,Integer.MAX_VALUE);
        desti[strt]=0;
        parent[strt]=strt;
        ArrayList<Integer> arl=new ArrayList<Integer>();

        dijas(vertices,al,parent,desti,strt,dest,arl);

        System.out.println("Distance value");
        for(Integer d1:desti)
        {
            System.out.println(Arrays.toString(desti));
            break;
        }
        System.out.println("Path rem array");
        for(Integer p1:parent)
        {
            System.out.println(Arrays.toString(parent));
            break;
        }
        System.out.println("Path from source to desti");
        Collections.reverse(arl);
        System.out.println(arl);
        //System.out.println(Arrays.asList(dest).contains(22));

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");
        int m=sc.nextInt();
        ArrayList<ArrayList<PairPQ>> l=AdjList.adjDis(m,n);
        System.out.println("Enter starting node");
        int strt=sc.nextInt();
        System.out.println("Enter dest node");
        int dest=sc.nextInt();
        PrintShortPath.trav(n,l,strt,dest);

    }
}
