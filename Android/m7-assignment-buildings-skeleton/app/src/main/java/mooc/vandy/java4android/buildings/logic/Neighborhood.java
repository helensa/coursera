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
        out.println(header);
        out.println("----------");

        for (Building building : buildings) {
            out.println(building.toString());
        }

        out.println(String.format("Total neighborhood area: %d", calcArea(buildings)));
    }


    public static int calcArea (Building[] buildings){

        int area = 0;

        for (Building building : buildings) {
            area += building.calcLotArea();
        }

        return area;
    }
}
