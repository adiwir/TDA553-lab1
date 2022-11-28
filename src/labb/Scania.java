package labb;

import java.awt.*;

public class Scania extends Car {

    private HasPlatform platform = new HasPlatform();

    public Scania() {
        super(4, 100, Color.GREEN, "Scania");
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
        if (platform.getPlatformAngle() != 70 && this.getCurrentSpeed() == 0) {
            platform.raisePlatform();
        }
    }

    public void lowerPlatform() {
        platform.lowerPlatform();        
    }

    public int getPlatformAngle() {
        return platform.getPlatformAngle();
    }
}
