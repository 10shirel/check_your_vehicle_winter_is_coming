package com.test.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by shirel on 06/07/2016.
 */


@Component
@Scope("prototype")
@Entity
public class Vehicle {

    @Id
    private String vin;

    private String manufacture;
    private String modelName;


    private /*transient */int speedometerNumber;


    protected Vehicle() {}

    public Vehicle(String manufacture, String modelName) {
        this.manufacture = manufacture;
        this.modelName = modelName;
    }

    public Vehicle(String vin, String manufacture, String modelName) {
        this(manufacture,modelName);
        this.vin = vin;
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

    public int getSpeedometerNumber() {
        return speedometerNumber;
    }

    public void setSpeedometerNumber(int speedometerNumber) {
        this.speedometerNumber = speedometerNumber;
    }
}
