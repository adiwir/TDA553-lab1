package labb;

import java.awt.*;
import java.util.Random;

public class CarTransporter extends Car {

    private HasPlatform platform = new HasPlatform();
    private HasStorage storage;
    private int range;
    private int maxCars;
    private Random random = new Random();

    public CarTransporter() {
        super(2, 100, Color.BLACK, "Transporter");
        maxCars = 8;        
        range = 10;
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
        if (platform.getPlatformAngle() != 1) {
            platform.raisePlatform();
        }
    }

    public void lowerPlatform() {
        if (platform.getPlatformAngle() != 0 && this.getCurrentSpeed() == 0) {
            platform.lowerPlatform();
        }
    }

    public void loadCar() { // inte ladda sig själv
        if (platform.getPlatformAngle() == 0) {
            storage.loadCar(this.getCurrentPositionX(), this.getCurrentPositionY());
        }
    }

    public void unloadCar() {
        if (platform.getPlatformAngle() == 0) { 
            storage.unloadCar(this.getCurrentPositionX() + random.nextInt(range), this.getCurrentPositionY() + random.nextInt(range));
        }
    }
}
