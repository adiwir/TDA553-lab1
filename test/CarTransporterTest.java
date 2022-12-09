import org.junit.Test;
import static org.junit.Assert.*;

public class CarTransporterTest {

    SpawnCar spawnCar = SpawnCar.getInstance();

    @Test
    public void car_transporter_should_not_load_car_when_ramp_is_up() {
        spawnCar.clearActiveCars();
        CarTransporter testCarTransporter = new CarTransporter();

        testCarTransporter.raisePlatform();
        spawnCar.addCar("Volvo240");
        testCarTransporter.loadCar();
        
        assertEquals(testCarTransporter.getStorage().size(), 0);
    }

    @Test
    public void car_transporter_should_load_car_when_ramp_is_down() {
        spawnCar.clearActiveCars();
        CarTransporter testCarTransporter = new CarTransporter();

        spawnCar.addCar("Volvo240");
        testCarTransporter.loadCar();

        assertEquals(testCarTransporter.getStorage().size(), 1);
    }
}
