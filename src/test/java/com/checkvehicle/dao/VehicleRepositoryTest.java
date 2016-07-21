package com.checkvehicle.dao;

import com.checkvehicle.model.Vehicle;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


/**
 * Created by shirel on 21/07/2016.
 */
public class VehicleRepositoryTest {

    static ApplicationContext appContext;
    static VehicleRepository vehicleRepository;
    List<Vehicle> vehicles;


    @BeforeClass
    public static void executedBeforeEach() {
        appContext = SpringApplication.run(com.checkvehicle.PersonalProjectApplication.class);
        vehicleRepository = appContext.getBean(VehicleRepository.class);
    }


    /**
     * This method validate:
     * That the Vin of the the vehicle is matching to the Vin that was sent as parameter.
     *
     * @throws Exception
     */
    @Test
    public void findVehicleByVin() throws Exception {
        vehicles = vehicleRepository.findVehicleByVin("22-222-22");
        if (vehicles.size() != 0) return;
        for (Vehicle vehicle : vehicles) {
            Assert.assertSame(vehicle.getmanufacture(), "22-222-22");
        }
    }


    /**
     * This method validate:
     * That the Manufacture of all the vehicles that retrives is matching to the Manufacture that was sent as parameter
     *
     * @throws Exception
     */
    @Test
    public void findVehiclesByManufacture() throws Exception {
        vehicles = vehicleRepository.findVehiclesByManufacture("Opel");
        if (vehicles.size() != 0) return;
        for (Vehicle vehicle : vehicles) {
            Assert.assertSame(vehicle.getmanufacture(), "Opel");
        }
    }


    /**
     * This method validate:
     * That the Model Name of all the vehicle that retrives is matching to the Model Name that was sent as parameter
     *
     * @throws Exception
     */
    @Test
    public void findVehiclesByModelName() throws Exception {
        vehicles = vehicleRepository.findVehiclesByModelName("Astra");
        if (vehicles.size() == 0) return;
        else {
            for (Vehicle vehicle : vehicles) {
                Assert.assertSame(vehicle.getModelName(), "Astra");
            }
        }
    }

}