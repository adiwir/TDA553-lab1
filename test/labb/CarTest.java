package labb;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {

  @Test
  public void current_speed_should_not_exceed_engine_power() {
    Car testVolvo = new Volvo240();
    testVolvo.setCurrentSpeed(testVolvo.getEnginePower() + 1);
    double newSpeed = testVolvo.getCurrentSpeed();
    assertEquals(testVolvo.getEnginePower(), newSpeed, 0.01);
  }

  @Test
  public void current_speed_should_not_go_below_zero() {
    Car testVolvo = new Volvo240();
    testVolvo.setCurrentSpeed(-1);
    double newSpeed = testVolvo.getCurrentSpeed();
    assertEquals(0, newSpeed, 0.01);
  }

  @Test
  public void gas_above_one_should_not_be_allowed() {
    Car testVolvo = new Volvo240();
    testVolvo.gas(1.1);
    assertEquals(0, testVolvo.getCurrentSpeed(), 0.01);
  }

  @Test
  public void gas_below_zero_should_not_be_allowed() {
    Car testVolvo = new Volvo240();
    testVolvo.gas(-1);
    assertEquals(0, testVolvo.getCurrentSpeed(), 0.01);
  }

  @Test
  public void brake_above_one_should_not_be_allowed() {
    Car testVolvo = new Volvo240();
    testVolvo.brake(1.1);
    assertEquals(0, testVolvo.getCurrentSpeed(), 0.01);
  }

  @Test
  public void brake_below_zero_should_not_be_allowed() {
    Car testVolvo = new Volvo240();
    testVolvo.brake(-1);
    assertEquals(0, testVolvo.getCurrentSpeed(), 0.01);
  }
  
  @Test
  public void gas_should_not_decrease_speed() {
    Car testVolvo = new Volvo240();
    double currentSpeed = testVolvo.getCurrentSpeed();
    testVolvo.gas(1);
    double newSpeed = testVolvo.getCurrentSpeed();
    assertTrue(newSpeed >= currentSpeed);
  }

  @Test
  public void brake_should_not_increase_speed() {
    Car testVolvo = new Volvo240();

    double currentSpeed = testVolvo.getCurrentSpeed();
    testVolvo.brake(1);
    double newSpeed = testVolvo.getCurrentSpeed();
    assertTrue(newSpeed <= currentSpeed);
  }
  
  @Test
  public void while_direction_left_turn_left_should_result_in_direction_down() {
    Car testVolvo = new Volvo240();

    testVolvo.turnLeft();
    assertEquals(1, testVolvo.getCurrentDir());
  }

  
  @Test
  public void while_direction_down_turn_left_should_result_in_direction_right() {
    Car testVolvo = new Volvo240();

    testVolvo.setCurrentDir(1);

    testVolvo.turnLeft();
    assertEquals(2, testVolvo.getCurrentDir());
  }

  
  @Test
  public void while_direction_right_turn_left_should_result_in_direction_up() {
    Car testVolvo = new Volvo240();

    testVolvo.setCurrentDir(2);

    testVolvo.turnLeft();
    assertEquals(3, testVolvo.getCurrentDir());
  }
  
  @Test
  public void while_direction_up_turn_left_should_result_in_direction_left() {
    Car testVolvo = new Volvo240();
    
    testVolvo.setCurrentDir(3);
    testVolvo.turnLeft();
    
    assertEquals(0, testVolvo.getCurrentDir());
  }
  

  @Test
  public void while_direction_left_turn_right_should_result_in_direction_up() {
    //
  }

  /*
  @Test
  public void while_direction_up_turn_right_should_result_in_direction_right() {
    //
  }

  @Test
  public void while_direction_right_turn_right_should_result_in_direction_down() {
    //
  }
  
  @Test
  public void while_direction_down_turn_right_should_result_in_direction_left() {
    //
  } */

  @Test
  public void a() {

    assertTrue(true);
  }
}
