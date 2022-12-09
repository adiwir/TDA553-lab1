import java.awt.*;
import java.util.ArrayList;

public class CarModel extends Car{

    private ArrayList<Car> cars = new ArrayList<Car>();

    public CarModel() {
        super(0, 0, Color.BLACK, "");
        createCars();
    }

    public double speedFactor() {
        return 0;
    }

    private void createCars() {
        cars.add(new Volvo240());
        cars.get(0).setPositionY(10);
        cars.get(0).setCurrentDir(Direction.RIGHT);

        cars.add(new Saab95());
        cars.get(1).setPositionY(210);
        cars.get(1).setCurrentDir(Direction.RIGHT);

        cars.add(new Scania());
        cars.get(0).setPositionY(410);
        cars.get(2).setCurrentDir(Direction.RIGHT);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    // Calls the gas method for each car once
    @Override
    public void gas(double amount) {
        for (Car car: cars) {
            car.gas(amount);
        }
    }
}