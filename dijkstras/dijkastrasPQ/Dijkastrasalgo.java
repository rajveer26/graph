package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.*;

public class Dijkastrasalgo
{
Dijkastrasalgo()
{
    super();
}

  public static void dijs(int vertices, ArrayList<ArrayList<PairPQ>> al, int[] distance, int start)
  {
      PriorityQueue<PairPQ> p=new PriorityQueue<PairPQ>(vertices,(PairPQ node1,PairPQ node2)->(node1.getWeight() < node2.getWeight()) ? -1:(node1.getWeight() > node2.getWeight()) ? 1:0);
       //Comparator is a functional interface.
      p.add(new PairPQ(start,0));
      while (!p.isEmpty())
      {  System.out.println(p);
          PairPQ vet=p.poll();

          for(PairPQ li:al.get(vet.getNode()))
          {
              if(distance[vet.getNode()]+li.getWeight()<distance[li.getNode()])
              {
                  distance[li.getNode()]=distance[vet.getNode()]+li.getWeight();
                  p.add(new PairPQ(li.getNode(),distance[li.getNode()]));
              }
          }

      }

  }

    public static void trav(int vertices, ArrayList<ArrayList<PairPQ>> al, int start)
    {

       int[] dist=new int[vertices+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

            dijs(vertices, al, dist, start);


           for (Integer dist1:dist)
           {
               System.out.println(Arrays.toString(dist));
               break;
           }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");
        int m=sc.nextInt();
        ArrayList<ArrayList<PairPQ>>l= AdjList.adjDis(m,n);
        System.out.println("Enter starting node");
        int start=sc.nextInt();
        Dijkastrasalgo.trav(n,l,start);


    }
}
