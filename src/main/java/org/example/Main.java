package org.example;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void computePaths(node source)
    {
        source.minDistance = 1.; //minimal distance betwenn points
        PriorityQueue<node> nodeQueue = new PriorityQueue<node>();
        nodeQueue.add(source);

        while (!nodeQueue.isEmpty()) {
            node u = nodeQueue.poll();

            // Visit each vertice exiting u



                for (vertice e : u.adjacencies)
                {
                    node v = e.target; //node to go
                    double length = e.length; //distance from the source to the next node to go
                    boolean nodeBlocked = e.blocked; //blocked node or not
                    double distanceThroughU = u.minDistance + length; //u.minDistance =0 (moverse 0);

                if (!nodeBlocked)
                {

                    if (distanceThroughU < v.minDistance) //si la distancia de u a ese punto es menor que la distancia a v
                    {
                        nodeQueue.remove(v);
                        v.minDistance = distanceThroughU;
                        v.previous = u;
                        nodeQueue.add(v);

                    }
                }


                }

        }
    }
    public static List<node> getShortestPathTo(node target)
    {
        List<node> path = new ArrayList<node>();
        for (node node = target; node != null; node = node.previous)
            path.add(node);

        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args)

    {

        // mark all the nodes

        node A1 = new node("A1");
        node B1 = new node("B1");
        node C1 = new node("C1");
        node A2= new node("A2");
        node B2 = new node("B2");
        node C2 = new node("C2");
        node A3 = new node("A3");
        node B3 = new node("B3");
        node C3 = new node("C3");

        // set the vertices and length /add if the path ist blocked or not

        A1.adjacencies = new vertice[]{ new vertice(B1, 1, true ), new vertice(A2,1, false) };
        B1.adjacencies = new vertice[]{ new vertice(C1, 1,false), new vertice(A1, 1,false), new vertice(B2, 1,false) };
        C1.adjacencies = new vertice[]{ new vertice(B1, 1,false), new vertice(C2, 1,true)};
        A2.adjacencies = new vertice[]{ new vertice(A3, 1,true), new vertice(B2, 1,true), new vertice(A1, 1,false)};
        B2.adjacencies = new vertice[]{ new vertice(B1, 1,false), new vertice(B3, 1,false), new vertice(C2, 1,false), new vertice(A2, 1,true)};
        C2.adjacencies = new vertice[]{ new vertice(C3, 1,false), new vertice(B2, 1,false), new vertice(C1, 1,false)};
        A3.adjacencies = new vertice[]{ new vertice(A2,1,true) ,new vertice(B3,1,false) };
        B3.adjacencies = new vertice[]{ new vertice(A3,1,false), new vertice(C3,1,false), new vertice(B2, 1,false)};
        C3.adjacencies = new vertice[]{ new vertice(C2, 1,false), new vertice(B3,1,false) };

        //Test 1

        computePaths(A1); // run Dijkstra
        //from A1 to C3
        System.out.println("Distance to " + C3 + ": " + C3.minDistance);
        List<node> path = getShortestPathTo(C3);
        System.out.println("Path to follow: " + path);

//        Test 2

        computePaths(A1); // run Dijkstra
        //from A1 to A3
        System.out.println("Distance from "+ A1 + " to " + A3 + ": " + A3.minDistance);
        List<node> path2 = getShortestPathTo(A3);
        System.out.println("Path to follow: " + path2);
    }
}