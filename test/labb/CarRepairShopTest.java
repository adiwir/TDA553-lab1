package labb;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarRepairShopTest {

    @Test
    public void car_close_to_repair_shop_should_be_loaded() {
        //Car testVolvo = new Volvo240();
        SpawnCar.addCar("Volvo240");
        //SpawnCar.getActiveCars().get(0);
        
        CarRepairShop testRepairShop = new CarRepairShop();

        testRepairShop.setPositionX(10);
        testRepairShop.setPositionY(10);

        testRepairShop.loadCar();

        assertEquals(testRepairShop.getStorage().get(0), SpawnCar.getActiveCars().get(0));
    }
}
