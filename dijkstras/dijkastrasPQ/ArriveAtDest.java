package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArriveAtDest
{
    ArriveAtDest()
    {
        super();
    }

    public static void trav(int vertices,ArrayList<ArrayList<PairPQ>> al,int source,int destination,int[] dis,int[] ways)
    {
        PriorityQueue<PairPQ> pq=new PriorityQueue<PairPQ>(vertices,(PairPQ node1,PairPQ node2)->(node1.getWeight() < node2.getWeight()) ? -1 :(node1.getWeight() >node2.getWeight()) ? 1 : 0);
        pq.add(new PairPQ(source,dis[source]));

        while (!pq.isEmpty()) {
            System.out.println(pq);
            PairPQ nde = pq.peek();//instead of using pq.peek() and declaring remove() we can directly use poll().
            pq.remove();
            for (PairPQ li : al.get(nde.getNode())) {
                if ((dis[nde.getNode()] + li.getWeight()) < dis[li.getNode()])
                {
                    dis[li.getNode()] = dis[nde.getNode()] + li.getWeight();
                    pq.add(new PairPQ(li.getNode(), dis[li.getNode()]));
                    ways[li.getNode()]+=ways[nde.getNode()];
                }
               else if((dis[nde.getNode()] + li.getWeight()) == dis[li.getNode()])
                {
                    ways[li.getNode()]+=ways[nde.getNode()];
                }



            }
        }
    }
    public static void arriveDestDijas(int vertices,ArrayList<ArrayList<PairPQ>> al,int source,int destination)
    {
        int[] dis=new int[vertices+1];
        int[] ways=new int[vertices+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Arrays.fill(ways,0);
        dis[source]=0;
        ways[source]=1;
        trav(vertices,al,source,destination,dis,ways);

        System.out.println("distance..\u2193");
        for(Integer d1:dis)
        {
            System.out.println(Arrays.toString(dis));
            break;
        }
        System.out.println("ways..\u2193");
        for(Integer w1: ways)
        {
            System.out.println(Arrays.toString(ways));
            break;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");
        int m=sc.nextInt();
        ArrayList<ArrayList<PairPQ>> l=AdjList.adjDis(m,n);
        System.out.println("Enter source");
        int src=sc.nextInt();
        System.out.println("Enter distance");
        int dest=sc.nextInt();
        ArriveAtDest.arriveDestDijas(n,l,src,dest);
    }
}
