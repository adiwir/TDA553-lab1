import org.junit.Test;
import static org.junit.Assert.*;

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
  public void while_Direction_left_turn_left_should_result_in_Direction_down() {
    Car testVolvo = new Volvo240();
    testVolvo.turnLeft();
    assertEquals(Car.Direction.DOWN, testVolvo.getCurrentDir());
  }

  
  @Test
  public void while_Direction_down_turn_left_should_result_in_Direction_right() {
    Car testVolvo = new Volvo240();
    testVolvo.setCurrentDir(Car.Direction.DOWN);
    testVolvo.turnLeft();
    assertEquals(Car.Direction.RIGHT, testVolvo.getCurrentDir());
  }

  
  @Test
  public void while_Direction_right_turn_left_should_result_in_Direction_up() {
    Car testVolvo = new Volvo240();

    testVolvo.setCurrentDir(Car.Direction.RIGHT);

    testVolvo.turnLeft();
    assertEquals(Car.Direction.UP, testVolvo.getCurrentDir());
  }
  
  @Test
  public void while_Direction_up_turn_left_should_result_in_Direction_left() {
    Car testVolvo = new Volvo240();
    
    testVolvo.setCurrentDir(Car.Direction.UP);
    testVolvo.turnLeft();
    
    assertEquals(Car.Direction.LEFT, testVolvo.getCurrentDir());
  }
  

  @Test
  public void while_Direction_left_turn_right_should_result_in_Direction_up() {
    Car testVovlo = new Volvo240();
    testVovlo.turnRight();
    assertEquals(Car.Direction.UP, testVovlo.getCurrentDir());
  }

  
  @Test
  public void while_Direction_up_turn_right_should_result_in_Direction_right() {
    Car testSaab = new Saab95();

    testSaab.setCurrentDir(Car.Direction.UP);
    testSaab.turnRight();

    assertEquals(Car.Direction.RIGHT, testSaab.getCurrentDir());
  }

  @Test
  public void while_Direction_right_turn_right_should_result_in_Direction_down() {
    Car testSaab = new Saab95();

    testSaab.setCurrentDir(Car.Direction.RIGHT);
    testSaab.turnRight();

    assertEquals(Car.Direction.DOWN, testSaab.getCurrentDir());
  }
  
  @Test
  public void while_Direction_down_turn_right_should_result_in_Direction_left() {
    Car testVolvo = new Volvo240();

    testVolvo.setCurrentDir(Car.Direction.DOWN);
    testVolvo.turnRight();

    assertEquals(Car.Direction.LEFT, testVolvo.getCurrentDir());
  } 

  @Test
  public void when_moving_left_position_in_the_Xaxis_is_less_than_ten() {
    Volvo240 testVolvo = new Volvo240();

    testVolvo.startEngine();
    testVolvo.gas(1);
    testVolvo.move();
    
    assertTrue(testVolvo.getCurrentPositionX() < 10);
  }

  @Test
  public void when_moving_up_position_in_the_Yaxis_is_greater_than_ten() {
    Saab95 testSaab = new Saab95();

    testSaab.setCurrentDir(Car.Direction.UP);
    testSaab.startEngine();
    testSaab.gas(1);
    testSaab.move();

    assertTrue(testSaab.getCurrentPositionY() < 10);
  }

  @Test
  public void when_moving_right_position_in_the_Xaxis_is_greater_than_ten() {
    Saab95 testSaab = new Saab95();

    testSaab.setCurrentDir(Car.Direction.RIGHT);
    testSaab.startEngine();
    testSaab.gas(1);
    testSaab.move();

    assertTrue(testSaab.getCurrentPositionX() > 10);
  }

  @Test
  public void when_moving_down_position_in_the_Yaxis_is_not_ten() {
    Saab95 testSaab = new Saab95();

    testSaab.setCurrentDir(Car.Direction.DOWN);
    testSaab.startEngine();
    testSaab.gas(1);
    testSaab.move();

    assertTrue(testSaab.getCurrentPositionY() > 10);
  }
}
