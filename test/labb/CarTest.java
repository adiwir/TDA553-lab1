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
  public void gas_above_one_should_not_increment_speed() {
    //
  }

  /*
  @Test
  public void gas_below_zero_should_not_increment_speed() {
    //
  }
  */

  @Test
  public void brake_above_one_should_not_decrement_speed() {
    //
  }

  /*
  @Test
  public void brake_below_zero_should_not_decrement_speed() {
    //
  }
  */

  @Test
  public void while_direction_left_turn_left_should_result_in_direction_down() {
    Car testVolvo = new Volvo240();

    testVolvo.turnLeft();
    assertEquals(2, testVolvo.getCurrentDir());
  }

  /*
  @Test
  public void while_direction_down_turn_left_should_result_in_direction_right() {
    //
  }

  @Test
  public void while_direction_right_turn_left_should_result_in_direction_up() {
    //
  }
  
  @Test
  public void while_direction_up_turn_left_should_result_in_direction_left() {
    //
  }
  */

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
}
