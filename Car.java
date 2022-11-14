import java.awt.*;

public abstract class Car implements Movable{
    
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double[] currentSpeed = new double[2]; // The current speed of the car
    private double[] position = new double[2]; //The cars position
    private Color color; // Color of the car
    private String modelName; // The car model name
 
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        
        this.currentSpeed[0] = 0;
        this.currentSpeed[1] = 0;
        this.position[0] = 10;
        this.position[1] = 10;
        
        this.color = color;
        this.modelName = modelName;
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    public double[] getCurrentSpeedX() {
        return this.currentSpeed;
    } 

    public double[] getCurrentSpeedY() {
        return this.currentSpeed;
    }

    protected void setCurrentSpeed(double[] currentSpeed) {
        this.currentSpeed[0] = currentSpeed[0];
        this.currentSpeed[1] = currentSpeed[1];
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
	    color = clr;
    }

    protected String getModelName(){
        return modelName;
    }

    public void startEngine() {
	    currentSpeed[0] = 0.1;
    }

    public void stopEngine() {
	    currentSpeed[0] = 0;
        currentSpeed[1] = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
    
    @Override
    public void move() {
        this.xpos = this.xpos + currentSpeed;
        this.ypos = this.ypos + currentSpeed;
    }

    @Override
    public void turnLeft() {
        
    }
    
    @Override
    public void turnRight() {
        
    }
}
