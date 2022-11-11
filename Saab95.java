import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn = false;
    
    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color){
        super(2, 125, 0, Color.red, "Saab95");
        //super(nrDoors = 2, enginePower, currentSpeed, color, modelName);
        
        /*
        this.setNrDoors(2);
        this.setColor(Color.red);
        this.setEnginePower(125);
        this.setModelName("Saab95");
	    this.turboOn = false;*/
        stopEngine();
    }                                                                                         
    
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
}
