package labb;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }
    
    @Override
    protected double speedFactor() {
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount) {
	    this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower())); ////////TODO Volvo clampar själv innan den tillkallar setcurrentspeed 
        //kanske kan ta bort och låta det skötas i Car. för borde gälla för alla bilar, och saab har ingen clamp från mallen...
    }

    @Override
    protected void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
