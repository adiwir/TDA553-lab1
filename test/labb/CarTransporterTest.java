package labb;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTransporterTest {

    @Test
    public void car_transporter_should_not_load_car_when_ramp_is_up() {
        SpawnCar.clearActiveCars();
        CarTransporter testCarTransporter = new CarTransporter();

        testCarTransporter.raisePlatform();
        SpawnCar.addCar("Volvo240");
        testCarTransporter.loadCar();
        
        assertEquals(testCarTransporter.getStorage().size(), 0);
    }

    @Test
    public void car_transporter_should_load_car_when_ramp_is_down() {
        SpawnCar.clearActiveCars();
        CarTransporter testCarTransporter = new CarTransporter();

        SpawnCar.addCar("Volvo240");
        testCarTransporter.loadCar();

        assertEquals(testCarTransporter.getStorage().size(), 1);
    }
}
