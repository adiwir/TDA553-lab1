package labb;

import java.awt.*;

public class Scania extends Car {

    private HasPlatform platform = new HasPlatform(70);

    public Scania() {
        super(4, 100, Color.GREEN, "Scania");
    }

    @Override
    public void startEngine() {
        if (platform.getPlatformAngle() == 0) {
            setCurrentSpeed(0.1);
        }
    }

    @Override
    double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        if (platform.getPlatformAngle() == 0) {
            incrementSpeed(amount);
        }
    }

    public void raisePlatform() {
        if (this.getCurrentSpeed() == 0) {
            platform.raisePlatform(1);
        }
    }

    public void lowerPlatform() {
        platform.lowerPlatform(1);
    }

    public int getPlatformAngle() {
        return platform.getPlatformAngle();
    }
}
