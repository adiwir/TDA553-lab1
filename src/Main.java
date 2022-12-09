public class Main {
    public static void main(String []args) {

        SpawnCar spawnCar = SpawnCar.getInstance();
        CarRepairShop testRepairShop = new CarRepairShop();
        
        spawnCar.addCar("Volvo240");
        spawnCar.addCar("Volvo240");
        System.out.println(spawnCar.getActiveCars());

        testRepairShop.setPositionX(10);
        testRepairShop.setPositionY(10);

        testRepairShop.loadCar();
        System.out.println(testRepairShop.getStorage().size());

        testRepairShop.unloadCar();
        System.out.println(testRepairShop.getStorage().size());
    }
}
