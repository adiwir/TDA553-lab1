import java.util.*;

public class SpawnCar {
    private static SpawnCar single_instance = null;
    private List<Car> activeCars = new ArrayList<Car>();

    public static SpawnCar getInstance() {
        if (single_instance == null) {
            single_instance = new SpawnCar();
        }
        return single_instance;
    }

    public void addCar(String type) {
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
    
    public List<Car> getActiveCars() {
        return activeCars;
    }

    public void clearActiveCars() {
        activeCars.clear();
    }
}