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

    @Test
    public void platform_should_not_go_lower_than_zero() {
        Scania testScania = new Scania();
        testScania.lowerPlatform();
        assertTrue(testScania.getPlatformAngle() == 0);
    }
}