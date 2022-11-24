package labb;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScaniaTest {

    @Test
    public void speed_should_not_change_with_raised_platform() {
        Scania testScania = new Scania();

        double startSpeed = testScania.getCurrentSpeed();
        
        testScania.raisePlatform();

        testScania.gas(1);

        double newSpeed = testScania.getCurrentSpeed();

        assertEquals(startSpeed, newSpeed, 0);


    }
}