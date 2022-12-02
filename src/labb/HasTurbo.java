package labb;

public class HasTurbo {
    
    private boolean turboOn;

    public HasTurbo() {
        this.turboOn = false;
    }

    public void setTurboOn() {
	    this.turboOn = true;
    }

    public void setTurboOff() {
	    this.turboOn = false;
    }

    public Boolean getTurbo() {
        return this.turboOn;
    }
}
