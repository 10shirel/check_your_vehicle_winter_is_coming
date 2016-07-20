package com.test.threads;

import com.test.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Created by shirel on 13/07/2016.
 */

@Component
@Scope("prototype")
public class SpecificInstanceToHandleCarActions implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpecificInstanceToHandleCarActions.class);


    private Vehicle vehicle;
    

    @Override
    public void run() {

        if(vehicle.getVin().equals("11-111-11")){
            checkLEFTWheelOfSpecificCar(10);
            checkRIGHTWheelOfSpecificCar(21);

        }else if (vehicle.getVin().equals("22-222-22")){
            checkLEFTWheelOfSpecificCar(100);
            checkRIGHTWheelOfSpecificCar(210);
        }else{
            checkLEFTWheelOfSpecificCar(1000);
            checkRIGHTWheelOfSpecificCar(2100);
        }
    }
    

    /**
     *  Check LEFT Wheel Of SpecificInstanceToHandleCarActions Car
     */
    private void checkLEFTWheelOfSpecificCar(int numberOfRounds) {
        LOGGER.info("LEFT wheel for Vin - " + vehicle.getVin() +  " - Checking...");
        turnTheWheelOfSpecificCarAndSide(numberOfRounds, "LEFT");
        LOGGER.info("LEFT wheel for Vin - " + vehicle.getVin() +  " - Was checked");

    }

    private void checkRIGHTWheelOfSpecificCar(int numberOfRounds) {
        LOGGER.info("RIGHT wheel for Vin -" + vehicle.getVin() +  " - Checking...");
        turnTheWheelOfSpecificCarAndSide(numberOfRounds, "RIGHT");
        LOGGER.info("RIGHT wheel for Vin - " + vehicle.getVin() +  " - Was checked");
    }

    /**
     * Turn the wheel of specific car and side
     *  @param numberOfRounds
     * @param side
     *
     */
    private void turnTheWheelOfSpecificCarAndSide(int numberOfRounds, String side) {
        int speedNumber;

        LOGGER.info("Before 'getSpeedometerNumber': Side = " + side + " - Speedo Number = " + vehicle.getSpeedometerNumber(null));
            speedNumber = vehicle.getSpeedometerNumber(side).get();
        LOGGER.info("After 'getSpeedometerNumber': Side = " + side + " - Speedo Number = " + vehicle.getSpeedometerNumber(null));


        LOGGER.info("Before 'setSpeedometerNumber': Side = " + side + " - Speedo Number = " + vehicle.getSpeedometerNumber(null));
            this.vehicle.setSpeedometerNumber(speedNumber + numberOfRounds);
        LOGGER.info("After 'setSpeedometerNumber' : " + "Vin = " + vehicle.getVin() + "** Side = " + side + " - Speedo Number = " + vehicle.getSpeedometerNumber(null));

    }




    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private int readSpeedometer() {
       return this.vehicle.getSpeedometerNumber(null).get();
    }


    public SpecificInstanceToHandleCarActions() {

    }


    public SpecificInstanceToHandleCarActions(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
