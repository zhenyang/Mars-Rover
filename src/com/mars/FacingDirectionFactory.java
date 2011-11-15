package com.mars;

import com.mars.Exception.ErrorDirectionException;

public class FacingDirectionFactory {
    public FacingDirection create(String shortName) throws ErrorDirectionException {
        if (shortName.equals("E")) {
            return FacingDirection.EAST;
        }
        if (shortName.equals("W")) {
            return FacingDirection.WEST;
        }
        if (shortName.equals("S")) {
            return FacingDirection.SOUTH;
        }
        if (shortName.equals("N")) {
            return FacingDirection.NORTH;
        }
        throw new ErrorDirectionException();
    }
}
