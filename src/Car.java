import java.awt.*;

public abstract class Car implements Movable{
    
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction dir;

    private Position position;
    
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        
        this.currentSpeed = 0;
        this.position = new Position(Config.CAR_START_POSITION_X, Config.CAR_START_POSITION_Y);

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
                this.position.setX(this.position.getX() - this.currentSpeed);
                break;
            case DOWN:
                this.position.setY(this.position.getY() + this.currentSpeed);
                break;
            case RIGHT:
                this.position.setX(this.position.getX() + this.currentSpeed);
                break;
            case UP:
                this.position.setY(this.position.getY() - this.currentSpeed);
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
        return this.position.getX();
    }

    public double getCurrentPositionY(){
        return this.position.getY();
    }

    public void setPositionX(double posX) {
        this.position.setX(posX);
    }

    public void setPositionY(double posY) {
        this.position.setY(posY);
    }
}
