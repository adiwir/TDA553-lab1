package labb;

import java.util.List;
import java.util.Random;

public class CarRepairShop {

    private int[] position = new int[2];
    private Random rand = new Random();
    private int maxCars;
    private List<Car> loadedCars;

    private HasStorage storage;

    public CarRepairShop() {
        this.maxCars = rand.nextInt(4, 20);
        this.storage = new HasStorage(maxCars);
        this.position[0] = rand.nextInt(0, 500);
        this.position[1] = rand.nextInt(0, 400);
    }

    public void loadCar() {
        this.storage.loadCar(this.position[0], this.position[1]);
    }

    public void unloadCar() {
        loadedCars = storage.getLoadedCars();
        double newCarPosX = loadedCars.get(loadedCars.size() - 1).getCurrentPositionX();
        double newCarPosY = loadedCars.get(loadedCars.size() - 1).getCurrentPositionY();
        storage.unloadCar(newCarPosX, newCarPosY);
    }

    public void setPositionX(int posX) {
        this.position[0] = posX;
    }

    public void setPositionY(int posY) {
        this.position[1] = posY;
    }

    public List<Car> getStorage() {
        return this.storage.getLoadedCars();
    }
}