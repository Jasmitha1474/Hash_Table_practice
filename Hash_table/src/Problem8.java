import java.util.*;

public class Problem8 {

    static String[] parking = new String[10];

    public static int hash(String plate) {
        return Math.abs(plate.hashCode()) % parking.length;
    }

    public static int parkVehicle(String plate) {

        int index = hash(plate);

        while (parking[index] != null) {
            index = (index + 1) % parking.length;
        }

        parking[index] = plate;

        return index;
    }

    public static void exitVehicle(String plate) {

        for (int i = 0; i < parking.length; i++) {

            if (plate.equals(parking[i])) {

                parking[i] = null;
                System.out.println("Vehicle exited from spot " + i);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Parked at spot: " + parkVehicle("ABC123"));
        System.out.println("Parked at spot: " + parkVehicle("XYZ999"));

        exitVehicle("ABC123");
    }
}
