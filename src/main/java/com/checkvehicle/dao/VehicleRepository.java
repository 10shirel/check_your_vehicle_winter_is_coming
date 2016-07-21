package com.checkvehicle.dao;

/**
 * Created by shirel on 11/07/2016.
 */

import com.checkvehicle.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findVehicleByVin(String vin);
    List<Vehicle> findVehiclesByManufacture(String manufacture);
    List<Vehicle> findVehiclesByModelName(String modelName);
}