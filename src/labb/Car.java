package labb;

import java.awt.*;

public abstract class Car implements Movable{
    
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private double[] position = new double[2]; //The cars position
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction dir;

    public enum Direction{
        LEFT,
        DOWN, 
        RIGHT,
        UP
    }
    
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        
        this.currentSpeed = 0;

        this.position[0] = Config.CAR_START_POSITION_X;
        this.position[1] = Config.CAR_START_POSITION_Y;

        this.dir = Direction.LEFT; // Start Direction left
        
        this.color = color;
        this.modelName = modelName;

        Direction.values();
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
            this.currentSpeed = 0;
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

    protected void incrementSpeed(double amount) {
        if (amount <= 1 && amount >= 0) {
            this.setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
    }

    protected void decrementSpeed(double amount) {
        if (amount <= 1 && amount >= 0) {
            this.setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
        }
    }

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }
    
    @Override
    public void move() {
        switch (this.dir){
            case LEFT:
                this.position[0] -= this.currentSpeed;
                break;
            case DOWN:
                this.position[1] += this.currentSpeed;
                break;
            case RIGHT:
                this.position[0] += this.currentSpeed;
                break;
            case UP:
                this.position[1] -= this.currentSpeed;
                break;
        }
    }

    @Override
    public void turnLeft() {
        if (this.dir == Direction.LEFT) {
            this.dir = Direction.DOWN;
        } else if (this.dir == Direction.DOWN) {
            this.dir = Direction.RIGHT;
        } else if (this.dir == Direction.RIGHT) {
            this.dir = Direction.UP;
        } else {
            this.dir = Direction.LEFT;
        }
    }
    
    @Override
    public void turnRight() {
        if (this.dir == Direction.LEFT) {
            this.dir = Direction.UP;
        } else if (this.dir == Direction.UP) {
            this.dir = Direction.RIGHT;
        } else if (this.dir == Direction.RIGHT) {
            this.dir = Direction.DOWN;
        } else {
            this.dir = Direction.LEFT;
        }
    }

    public Direction getCurrentDir() {
        return this.dir;
    }

    public void setCurrentDir(Direction dir) {
        this.dir = dir;
    }

    public double getCurrentPositionX(){
        return this.position[0];
    }

    public double getCurrentPositionY(){
        return this.position[1];
    }

    public void setPositionX(double posX) {
        this.position[0] = posX;
    }

    public void setPositionY(double posY) {
        this.position[1] = posY;
    }
}
