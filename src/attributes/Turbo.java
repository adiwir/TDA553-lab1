public class Turbo {
    
    private boolean turboOn;

    public Turbo() {
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
