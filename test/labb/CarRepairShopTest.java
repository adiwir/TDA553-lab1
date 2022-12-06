package labb;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarRepairShopTest {

    @Test
    public void car_close_to_repair_shop_should_be_loaded() {
        SpawnCar.clearActiveCars();
        CarRepairShop testRepairShop = new CarRepairShop();
        
        SpawnCar.addCar("Volvo240");
        testRepairShop.setPositionX(Config.CAR_START_POSITION_X);
        testRepairShop.setPositionY(Config.CAR_START_POSITION_Y);
        testRepairShop.loadCar();
        
        assertEquals(1, testRepairShop.getStorage().size());
    }

    @Test
    public void repair_shop_with_loaded_car_should_be_unloaded() {
        CarRepairShop testRepairShop = new CarRepairShop();

        testRepairShop.getStorage().add(new Volvo240());
        testRepairShop.unloadCar();

        assertEquals(testRepairShop.getStorage().size(), 0);
    }
}
