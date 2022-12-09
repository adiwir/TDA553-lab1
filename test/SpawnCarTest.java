import org.junit.Test;
import static org.junit.Assert.*;

public class SpawnCarTest {

    SpawnCar spawnCar = SpawnCar.getInstance();

    @Test
    public void create_a_newCar() {
        spawnCar.addCar("Volvo240");

        assertEquals(1, spawnCar.getActiveCars().size());
    }
}
