import org.junit.Test;
import static org.junit.Assert.*;

public class SpawnCarTest {

    @Test
    public void create_a_newCar() {
        SpawnCar.addCar("Volvo240");

        assertEquals(1, SpawnCar.getActiveCars().size());
    }
}
