package com.checkvehicle.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shirel on 20/07/2016.
 */
public class VehicleTest {
    @Test
    public void vehicle() {
        Vehicle vehicle = new Vehicle("99-999-99","VOLVO","S-80");
        Assert.assertEquals("Vehicle{vin=99-999-99_manufacture=VOLVO_modelName=S-80}",vehicle.toString());
     }

    @Test
    public void vehicleWithoutVin() {
        Vehicle vehicle = new Vehicle("VOLVO","S-80");
        Assert.assertEquals("Vehicle{vin=null_manufacture=VOLVO_modelName=S-80}",vehicle.toString());
     }

}