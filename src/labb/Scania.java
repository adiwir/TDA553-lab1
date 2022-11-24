package labb;

import java.awt.*;

public class Scania extends Car {

    private HasPlatform platform;

    public Scania() {
        super(4, 100, Color.GRAY, "Scania");
    }

    @Override
    double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

    public void raisePlatform() {
        if (platform.getPlatformAngle() != 70 && this.getCurrentSpeed() == 0) {
            platform.raisePlatform();
        }
    }

    public void lowerPlatform() {
        if (platform.getPlatformAngle() != 0) {
            platform.lowerPlatform();
        }
    }
}
