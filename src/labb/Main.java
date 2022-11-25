package labb;

import java.util.*;

public class Main {

    public static void main(String []args) {

        CarRepairShop testRepairShop = new CarRepairShop();
        SpawnCar spawnedCars = SpawnCar.getInstance();
        spawnedCars.addCar("Volvo240");
        SpawnCar.addCar("Volvo240");

        testRepairShop.setPositionX(10);
        testRepairShop.setPositionY(10);

        testRepairShop.loadCar();

        System.out.println(testRepairShop.getStorage().size());
        System.out.println(testRepairShop.getStorage().get(0));
        System.out.println(SpawnCar.getActiveCars().size());

        testRepairShop.unloadCar();
        System.out.println(testRepairShop.getStorage().size());
        System.out.println(SpawnCar.getActiveCars().size());
    }
    /*
    public static List<Car> cars = new ArrayList<Car>();
    
    public static List<Car> getActiveCars() {
        return cars;
    }

    public static void addActiveCar(Car car) {
        cars.add(car);
    }*/
}
