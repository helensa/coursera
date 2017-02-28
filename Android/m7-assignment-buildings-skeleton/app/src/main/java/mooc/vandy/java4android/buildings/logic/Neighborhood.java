package mooc.vandy.java4android.buildings.logic;

import java.io.FileNotFoundException;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor, as per https://en.wikipedia.org/wiki/Utility_class.
 */
public final class Neighborhood {

    private Neighborhood() {
    }

    public static void print (Building[] buildings, String header, OutputInterface out){

    }

    public static int calArea (Building[] buildings){

        int area = 0;
        for (int i = 0; i < buildings.length; i++){
            area = area + buildings[i].calcLotArea();
        }
        return area;
    }
}
