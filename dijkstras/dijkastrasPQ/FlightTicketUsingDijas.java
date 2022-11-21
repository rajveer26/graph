package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

import java.util.*;

public class FlightTicketUsingDijas
{
    FlightTicketUsingDijas()
    {
        super();
    }

    public static void flialgo(int vertices, ArrayList<ArrayList<PairPQ>> al, int[] dist, int dest, int src,int k,int[] parent,ArrayList<Integer> arl,int[] stops)
    {

        Queue<FlightQueue> qu=new LinkedList<FlightQueue>();
        qu.add(new FlightQueue(0,src,0));
        while (!qu.isEmpty())
        {
            FlightQueue vt=qu.poll();
            //qu.remove();
            int st=vt.getStops();
            //System.out.println(++st);
            if(st>k)
                continue;

            for(PairPQ li: al.get(vt.getVert())) {
                System.out.println(qu);

                // System.out.println("dist "+dist[vt.getVert()] +" wei "+ li.getWeight() +" dist node " +dist[li.getNode()]);
                if (st <= k+1) {
                    if (dist[vt.getVert()] + li.getWeight() < dist[li.getNode()]&&st<(stops[li.getNode()])) {
                        dist[li.getNode()] = dist[vt.getVert()] + li.getWeight();
                        // System.out.println(dist[li.getNode()]);
                        parent[li.getNode()] = vt.getVert();
                        //parent[p1.getNode()]=vt.getNode();
                        qu.offer(new FlightQueue(st + 1, li.getNode(), dist[li.getNode()]));
                        stops[li.getNode()]=st+1;
                    }
                }
            }
        }
        while (parent[dest]!=dest)
        {
            arl.add(dest);
            dest=parent[dest];
        }
        arl.add(src);
    }

    public static void display(int vertices, ArrayList<ArrayList<PairPQ>> al, int dest, int src,int stop)
    {
        int[] distance=new int[vertices+1];
        int[] parent=new int[vertices+1];
        int[] stops=new int[vertices+1];

        Arrays.fill(stops,Integer.MAX_VALUE);
        stops[src]=0;
        ArrayList<Integer> arl=new ArrayList<Integer>();
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        parent[src]=src;
        flialgo(vertices,al,distance,dest,src,stop,parent,arl,stops);
        for(Integer d1 : distance)
        {
            System.out.println(Arrays.toString(distance));
            break;

        }
        Collections.reverse(arl);
        System.out.println("Path-> "+arl);
        for(Integer s1 : stops)
        {
            System.out.println(Arrays.toString(stops));
            break;

        }



    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices");
        int n=sc.nextInt();
        System.out.println("Enter edges");
        int m=sc.nextInt();
        ArrayList<ArrayList<PairPQ>> l=AdjDir.adjDir(m,n);
        System.out.println("Enter source");
        int src=sc.nextInt();
        System.out.println("Enter dest");
        int dest=sc.nextInt();
        System.out.println("Enter the maximum stops that u want");
        int stop=sc.nextInt();
        FlightTicketUsingDijas.display(n,l,dest,src,stop);
    }
}
