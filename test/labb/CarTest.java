package labb;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {


  
  @Test
  public void current_speed_should_not_exceed_engine_power() {
    Car testVolvo = new Volvo240();
    
    testVolvo.setCurrentSpeed(testVolvo.getEnginePower() + 1);
    double newSpeed = testVolvo.getCurrentSpeed();
    assertEquals(newSpeed, testVolvo.getEnginePower(), 0.01);
  }

  @Test
  public void a() {
    //
  }

  @Test
  public void b() {
    Car testVolvo = new Volvo240();

    testVolvo.turnLeft();
    assertEquals(2, testVolvo.getCurrentDir());
  }
}