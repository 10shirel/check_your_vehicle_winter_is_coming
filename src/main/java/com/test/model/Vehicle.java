package com.test.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shirel on 06/07/2016.
 */


@Entity
public class Vehicle {

    private static final Logger LOGGER = LoggerFactory.getLogger(Vehicle.class);

    @Id
    private String vin;

    private String manufacture;
    private String modelName;


    private AtomicInteger speedometerNumber = new AtomicInteger(0);


    protected Vehicle() {}

    public Vehicle(String manufacture, String modelName) {
        this.manufacture = manufacture;
        this.modelName = modelName;
    }

    public Vehicle(String vin, String manufacture, String modelName) {
        this(manufacture,modelName);
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                "_manufacture=" + manufacture +
                "_modelName=" + modelName +
                '}';
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getmanufacture() {
        return manufacture;
    }

    public void setmanufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public AtomicInteger getSpeedometerNumber(String side) {
        LOGGER.info("In 'getSpeedometerNumber': Side = " + side + " - Speedo Number = " + speedometerNumber);
        return speedometerNumber;
    }

    public void setSpeedometerNumber(int speedometerNumber) {
        this.speedometerNumber = new AtomicInteger(speedometerNumber);
    }
}
