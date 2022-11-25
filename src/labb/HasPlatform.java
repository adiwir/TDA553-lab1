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
        if(this.platformAngle == 0) {
            this.platformAngle = 0;
        }
        else {
            this.platformAngle -= 1;
        }
    }

    public int getPlatformAngle() {
        return this.platformAngle;
    }
}
