package labb;

public class HasPlatform {

    private int platformAngle;
    private int maxAngle;

    public HasPlatform(int maxAngle) {
        this.platformAngle = 0;
        this.maxAngle = maxAngle;
    }

    public void raisePlatform(int amount) {
        this.platformAngle = Math.min((this.platformAngle + amount), this.maxAngle);
    }

    public void lowerPlatform(int amount) {
        this.platformAngle = Math.max((this.platformAngle - amount), 0);
    }

    public int getPlatformAngle() {
        return this.platformAngle;
    }
}
