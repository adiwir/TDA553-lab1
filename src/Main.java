public class Main {
    public static void main(String []args) {

        CarRepairShop testRepairShop = new CarRepairShop();
        
        SpawnCar.addCar("Volvo240");
        SpawnCar.addCar("Volvo240");
        System.out.println(SpawnCar.getActiveCars());

        testRepairShop.setPositionX(10);
        testRepairShop.setPositionY(10);

        testRepairShop.loadCar();
        System.out.println(testRepairShop.getStorage().size());

        testRepairShop.unloadCar();
        System.out.println(testRepairShop.getStorage().size());
    }
}
