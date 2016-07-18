package com.test.utils;

/**
 * Created by shirel on 13/07/2016.
 */
public class Constants {

    //Vehicle
    public static final String MANUFACTURE = "manufacture";
    public static final String MODEL_NAME = "modelName";

    //VehicleController
    public static final String API_VEHICLES = "/api/vehicles";
    public static final String FIND_VEHICLES_BY_VIN = "/findVehicleByVin/{vin}";
    public static final String FIND_VEHICLES_BY_MANUFACTURE = "/findVehiclesByManufacture";
    public static final String FIND_VEHICLES_BY_MODEL_NAME = "/findVehiclesByModelName";
    public static final String CHECK_WHEELS_OF_CARS = "/checkWheelsOfCars";

    //Person
    public static final String ID = "id";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";

    //PersonController
    public static final String API_PERSONS = "/api/persons";
    public static final String FIND_PERSONS_BY_FIRST_NAME = "/findPersonsByFirstName";
    public static final String FIND_PERSONS_BY_LAST_NAME = "/findPersonsByLastName";
    public static final String FIND_PERSON_BY_ID = "/findPersonById/{id}";
}
