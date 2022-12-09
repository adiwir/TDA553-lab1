import java.util.*;

public class Storage {

    private int maxCars;
    private ArrayList<Car> loadedCars;
    private int range;
    private SpawnCar spawnCar = SpawnCar.getInstance();

    public Storage(int maxCars) {
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<Car>();
        this.range = Config.RANGE;
    }

    public void setMaxCars(int amount) {
        this.maxCars = amount;
    }

    public List<Car> getLoadedCars() {
        return this.loadedCars;
    }

    public void loadCar(double posX, double posY) {
        ArrayList<Car> activeCars = new ArrayList<>(spawnCar.getActiveCars());
        for (Car car : activeCars) {
            if ((car.getCurrentPositionX() < posX + range) && (car.getCurrentPositionX() > posX - range)) {
                if ((car.getCurrentPositionY() < posY + range) && (car.getCurrentPositionY() > posY - range)) {
                    if (loadedCars.size() <= maxCars) {
                        loadedCars.add(car);
                        spawnCar.getActiveCars().remove(car);
                    }
                }
            }
        }
    }

    public void unloadCar(double xPos, double yPos) {
        if (loadedCars.size() != 0) {
            Car car = loadedCars.remove(loadedCars.size() - 1);
            spawnCar.getActiveCars().add(car);

            car.setPositionX(xPos);
            car.setPositionY(yPos);
        }
    }
}
