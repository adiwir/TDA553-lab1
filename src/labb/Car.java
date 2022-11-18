package labb;

import java.awt.*;

public abstract class Car implements Movable{
    
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private double[] position = new double[2]; //The cars position
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int currentDir;
 
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        
        this.currentSpeed = 0;

        this.position[0] = 10; // Start position
        this.position[1] = 10; //
        
        this.color = color;
        this.modelName = modelName;
        this.currentDir = 0; // Start direction (left)
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    } 

    protected void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= 0) {
            this.currentSpeed = Math.min(currentSpeed, enginePower);
        }

        else if (currentSpeed < 0) {
            this.currentSpeed = Math.max(currentSpeed, 0);
        }
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
	    currentSpeed = 0.1;
    }

    public void stopEngine() {
	    currentSpeed = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }
    
    @Override
    public void move() {
        switch (this.currentDir){
            case 0: // Left
                this.position[0] -= this.currentSpeed;
                break;
            case 1: // Down
                this.position[1] += this.currentSpeed;
                break;
            case 2: // Right
                this.position[0] += this.currentSpeed;
                break;
            case 3: // Up
                this.position[1] -= this.currentSpeed;
                break;
        }
    }

    @Override
    public void turnLeft() {
        if (this.currentDir == 3) {
            this.currentDir = 0;
        } else {
            this.currentDir += 1;
        }
    }
    
    @Override
    public void turnRight() {
        if (this.currentDir == 0) {
            this.currentDir = 3;
        } else {
            this.currentDir -= 1;
        }
    }

    public int getCurrentDir() {
        return this.currentDir;
    }

    public void setCurrentDir(int currentDir) {
        this.currentDir = currentDir;
    }

    public double getPositionX() {
        return this.position[0];
    }
}
