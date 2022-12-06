package labb;

import java.util.List;
import java.util.Random;

public class CarRepairShop {

    private Random rand = new Random();
    private int maxCars;
    private List<Car> loadedCars;

    private HasPosition position;
    private HasStorage storage;

    public CarRepairShop() {
        this.maxCars = rand.nextInt(4, 20);
        this.storage = new HasStorage(maxCars);
        this.position = new HasPosition(rand.nextInt(0, 500), rand.nextInt(0, 400));
        this.loadedCars = storage.getLoadedCars();
    }

    public void loadCar() {
        this.storage.loadCar(this.position.getX(), this.position.getY());
    }

    public void unloadCar() {
        double newCarPosX = this.loadedCars.get(this.loadedCars.size() - 1).getCurrentPositionX();
        double newCarPosY = this.loadedCars.get(this.loadedCars.size() - 1).getCurrentPositionY();
        storage.unloadCar(newCarPosX, newCarPosY);
    }

    public void setPositionX(int posX) {
        this.position.setX(posX);
    }

    public void setPositionY(int posY) {
        this.position.setY(posY);
    }

    public List<Car> getStorage() {
        return this.storage.getLoadedCars();
    }
}