package labb;

public class HasPlatform {

    private int platformAngle;

    public HasPlatform() {
        this.platformAngle = 0;
    }

    public void raisePlatform() {
        this.platformAngle += 1;
    }

    public void lowerPlatform() {
        this.platformAngle -= 1;
    }

    public int getPlatformAngle() {
        return this.platformAngle;
    }
}
