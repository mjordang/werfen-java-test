package com.systelab.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<String>  northOrigin= new ArrayList<>(Arrays.asList("NORTH","SOUTH"));
        ArrayList<String>  southOrigin = new ArrayList<>(Arrays.asList("SOUTH","NORTH"));
        ArrayList<String>  eastOrigin=  new ArrayList<>(Arrays.asList("EAST", "WEST"));
        ArrayList<String>  westOrigin=  new ArrayList<>(Arrays.asList("WEST","EAST"));
        ArrayList<String> directions= new ArrayList<>(Arrays.asList(arr));

        int directionNorth;
        int directionEast;
        int directionSouth;
        int directionWest;

        do{
            directionNorth = reduceDirection(directions,northOrigin);
            directionEast = reduceDirection(directions,eastOrigin);
            directionSouth = reduceDirection(directions,southOrigin);
            directionWest =  reduceDirection(directions,westOrigin);

        } while ( directionNorth!=-1||directionEast!=-1 || directionSouth!=-1 || directionWest!=-1);

        return directions.stream().toArray(String[]::new);
    }

    private static int oppositeDirectionsPosition( ArrayList<String> directions, ArrayList<String> direction ) {
        return Collections
                .indexOfSubList(directions,
                                direction
                );
    }

    private static void removeOppositeDirections( ArrayList<String> directions,int index) {
        //For with two loops to remove the firs element of the opposite direction pair(ex: NORTH, SOUTH) and the second one
        //with the same index, due that once removed the first the second one is moved to the position
        //of the first one
        for(int i=0;i<=1;i++){
            directions.remove(index);
        }
    }

    private static int  reduceDirection(ArrayList<String> directions,
                                        ArrayList<String> direction){
        int directionPosition = oppositeDirectionsPosition(directions,direction);
        if (directionPosition !=-1) {
            removeOppositeDirections(directions,directionPosition);
        }

        return directionPosition;
    }

}

