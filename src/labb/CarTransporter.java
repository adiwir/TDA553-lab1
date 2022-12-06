package labb;

import java.awt.*;
import java.util.Random;
import java.util.List;

public class CarTransporter extends Car {

    private HasPlatform platform = new HasPlatform(1);
    private HasStorage storage;
    private int range;
    private int maxCars;
    private Random random = new Random();

    public CarTransporter() {
        super(2, 100, Color.BLACK, "Transporter");
        maxCars = Config.STORAGE_MAX_CARS;        
        range = Config.RANGE;
        storage = new HasStorage(maxCars);
    }

    @Override
    double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        if (amount <= 1 && amount >= 0 && platform.getPlatformAngle() == 1) {
            incrementSpeed(amount);
        }
    }

    public void raisePlatform() {
        platform.raisePlatform(1);
    }

    public void lowerPlatform() {
        if (this.getCurrentSpeed() == 0) {
            platform.lowerPlatform(1);
        }
    }

    public void loadCar() {
        if (platform.getPlatformAngle() == 0) {
            storage.loadCar(this.getCurrentPositionX(), this.getCurrentPositionY());
        }
    }

    public void unloadCar() {
        if (platform.getPlatformAngle() == 0) { 
            storage.unloadCar(this.getCurrentPositionX() + random.nextInt(range), this.getCurrentPositionY() + random.nextInt(range));
        }
    }

    public List<Car> getStorage() {
        return storage.getLoadedCars();
    }
}
