package org.example;

public class node implements Comparable<node>{
    public final String name;
    public vertice[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY; //look the minimun value
    public node previous;
    public node(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}
