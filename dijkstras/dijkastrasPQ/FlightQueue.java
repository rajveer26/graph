package com.java.algoveer.graph.dijkstras.dijkastrasPQ;

public class FlightQueue
{
    private int stops,vert,dist;

    FlightQueue(int stops,int vert,int dist)
    {
        this.stops=stops;
        this.vert=vert;
        this.dist=dist;
    }

    public int getStops() {
        return stops;
    }

    public int getVert() {
        return vert;
    }

    public int getDist() {
        return dist;
    }

    public String toString()
    {
        return stops+","+vert+","+dist;
    }
}
