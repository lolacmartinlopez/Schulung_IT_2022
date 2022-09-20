package org.example;

public class vertice {
    public final node target;
    public final double length;
    public boolean blocked;
    public vertice(node argTarget, double arglength, boolean argBlocked) // get set properties
    { target = argTarget; length = arglength; blocked= argBlocked;}
}
