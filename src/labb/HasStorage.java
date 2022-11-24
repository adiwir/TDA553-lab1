package labb;

import java.util.*;

public class HasStorage {

    private int maxCars;
    private ArrayList<Car> loadedCars;

    public HasStorage() {
        this.maxCars = 0;
        loadedCars = new ArrayList<Car>();
    }

    public void setMaxCars(int amount) {
        this.maxCars = amount;
    }

    public List<Car> getLoadedCars() {
        return this.loadedCars;
    }

    public void loadCar(Car car) {
        if (loadedCars.size() <= maxCars) {
            loadedCars.add(car);
            Main.getActiveCars().remove(car);
        }
    }

    public void unloadCar() {
        if (loadedCars.size() != 0) {
            Car car = loadedCars.remove(loadedCars.size() - 1);
            Main.getActiveCars().add(car);
            /////car.setposition;////////////
        }
    }
}
