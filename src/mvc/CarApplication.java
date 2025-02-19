import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarApplication {
    // member fields:

    private static final int X = 800;
    private static final int Y = 800;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    static private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    static private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    static CarView frame;

    static CarModel cm = new CarModel();
    static CarController cc = new CarController();

    static ArrayList<Car> cars;

    //methods:

    public static void main(String[] args) {
        CarPanel panel = new CarPanel(X, Y-240);

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", panel);

        // Adding listeners for objects in CarView
        cc.addGasSpinnerListener(frame.gasSpinner);
        cc.addGasButtonListener(frame.gasButton, cm);

        cars = cm.getCars();

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    static private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            for (Car car : cars) {
                
                car.move();
                
                int x = (int) Math.round(car.getCurrentPositionX());
                int y = (int) Math.round(car.getCurrentPositionY());
                
                frame.panel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.panel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = (double) amount / 100;
        cm.gas(gas);
    }
}
