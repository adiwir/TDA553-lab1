import java.awt.*;

public class Saab95 extends Car{

    private Turbo turbo = new Turbo();
    
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        stopEngine();
    }
    
    public void setTurboOn() {
        turbo.setTurboOn();
    }

    public void setTurboOff() {
        turbo.setTurboOff();
    }
    
    @Override
    protected double speedFactor() {
        double turboFactor = 1;
        if(turbo.getTurbo()) turboFactor = 1.3;
        return this.getEnginePower() * 0.01 * turboFactor;
    }
}
