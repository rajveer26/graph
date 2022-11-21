package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.*;

public class MinMulti
{
    static int mod=100000, count;
    MinMulti()
    {
        super();
    }
    public static void trav(int vertices, int start,int end,ArrayList<Integer> l,int[] dist) {
        Queue<PairPQ> pq = new LinkedList<PairPQ>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        pq.add(new PairPQ(start, dist[start]));
        while (!pq.isEmpty()) {
            PairPQ p = pq.poll();
            int st = p.getWeight();
            int num = p.getNode();
            if(al.contains(end))
                break;
            st++;
            count=st;


            for (int i = 0; i < l.size(); i++) {
                al.add(i,(num * l.get(i))%100000);
                dist[p.getNode()]=st;
                pq.add(new PairPQ(al.get(i), dist[p.getNode()]));


            }


        }
        System.out.println(count);
        System.out.println(al);
        System.out.println(pq);
    }

    public static void muldij(int vertices, int start,int end,ArrayList<Integer> l)
    {
      int[] dis=new int[vertices+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start]=0;

        trav(vertices,start,end,l,dis);


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");
        int m=sc.nextInt();
        System.out.println("Enter start");
        int st=sc.nextInt();
        System.out.println("Enter end");
        int ed=sc.nextInt();
        System.out.println("Enter size of list");
        int siz=sc.nextInt();
        Integer[] l=new Integer[siz];
        for (int i=0;i<l.length;i++)
        {
            l[i]=sc.nextInt();
        }
        List<Integer> all= Arrays.asList(l);
        ArrayList al=new ArrayList(all);
        MinMulti.muldij(n,st,ed,al);

    }

}
