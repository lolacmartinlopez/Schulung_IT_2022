package org.example;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void computePaths(node source) {
        source.minDistance = 0.;
        PriorityQueue<node> nodeQueue = new PriorityQueue<node>();
        nodeQueue.add(source);

        while (!nodeQueue.isEmpty()) {
            node u = nodeQueue.poll();

            // Visit each vertice exiting u
            for (vertice e : u.adjacencies) {
                node v = e.target;
                double length = e.length;
                double distanceThroughU = u.minDistance + length;
                if (distanceThroughU < v.minDistance) {
                    nodeQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    nodeQueue.add(v);
                }
            }
        }
    }
}
