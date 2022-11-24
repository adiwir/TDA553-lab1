package labb;

import java.awt.*;

public class CarTransporter extends Car {

    private HasPlatform platform;
    private HasStorage storage;

    private int range;
    private int maxCars;

    public CarTransporter() {
        super(2, 100, Color.BLACK, "Transporter");
        range = 10;
        maxCars = 8;
        storage.setMaxCars(maxCars);
    }

    @Override
    double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

    public void raisePlatform() {
        if (platform.getPlatformAngle() != 1) {
            platform.raisePlatform();
        }
    }

    public void lowerPlatform() {
        if (platform.getPlatformAngle() != 0) {
            platform.lowerPlatform();
        }
    }

    public void loadCar() {
        for (Car car : Main.getActiveCars()) {
            if ((car.getCurrentPositionX() < this.getCurrentPositionX() + range) && (car.getCurrentPositionX() > this.getCurrentPositionX() - range)) {
                if ((car.getCurrentPositionY() < this.getCurrentPositionY() + range) && (car.getCurrentPositionY() > this.getCurrentPositionY() - range)) {
                        storage.loadCar(car);
                }
            }
        }

    }

    public void unloadCar() {
        storage.unloadCar();
    }
}