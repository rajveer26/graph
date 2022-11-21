package com.java.algoveer.graph.bellmanFord;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjlistBM
{
    static Scanner sc=new Scanner(System.in);
    AdjlistBM()
    {
        super();
    }

    public static ArrayList<NodeBM> adjBM(int m, int n)
    {

        ArrayList<NodeBM> al=new ArrayList<NodeBM>();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter u");
            int u=sc.nextInt();
            System.out.println("Enter v");
            int v=sc.nextInt();
            System.out.println("Enter wt");
            int wt=sc.nextInt();
            al.add(new NodeBM(u,v,wt));
        }
        System.out.println(al);
        return al;
    }

    public static void main(String[] args)
    {
      System.out.println("Enter vertices");
      int m=sc.nextInt();
      System.out.println("Enter edges");
      int n=sc.nextInt();
      AdjlistBM.adjBM(m,n);
    }

}
