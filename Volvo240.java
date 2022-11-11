import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.setNrDoors(4);
        this.setColor(Color.black);
        this.setEnginePower(100);
        this.setModelName("Volvo240");
        stopEngine();
    }
    
    @Override
    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
