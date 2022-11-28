package labb;

import java.util.*;

public class SpawnCar {
    private static SpawnCar single_instance = null;
    private static List<Car> activeCars = new ArrayList<Car>();

    private SpawnCar() {

    }

    public static SpawnCar getInstance() {
        if (single_instance == null) {
            single_instance = new SpawnCar();
        }
        return single_instance;
    }

    public static void addCar(String type) {
        switch (type) {
            case "Volvo240":
                Car volvo = new Volvo240();
                activeCars.add(volvo);
                break;
            case "Saab95":
                Car saab = new Saab95();
                activeCars.add(saab);
                break;
            case "Scania":
                Car scania = new Scania();
                activeCars.add(scania);
                break;
        }
    }
    
    public static List<Car> getActiveCars() {
        return activeCars;
    }

    public static void clearActiveCars() {
        activeCars.clear();
    }
}