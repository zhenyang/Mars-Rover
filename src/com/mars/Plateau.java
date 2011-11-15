package com.mars;

import com.mars.Exception.InvalidEdgeException;

public class Plateau {
    private int edgeX;
    private int edgeY;

    public Plateau(int edgeX, int edgeY) throws InvalidEdgeException {
        if (edgeX <= 0 || edgeY <= 0 )
        {
            throw new InvalidEdgeException();
        }
        this.edgeX = edgeX;
        this.edgeY = edgeY;
    }

    public int getEdgeX() {
        return edgeX;
    }

    public int getEdgeY() {
        return edgeY;
    }
}
