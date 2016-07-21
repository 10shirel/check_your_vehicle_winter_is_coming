package com.checkvehicle.ws.api;

import com.checkvehicle.PersonalProjectApplication;
import com.checkvehicle.handlevehicle.MngThreadsToHandleSpecificCar;
import com.checkvehicle.model.Vehicle;
import com.checkvehicle.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shirel on 06/07/2016.
 */

@RestController
@RequestMapping(Constants.API_VEHICLES)
public class VehicleController {


    @Autowired
    PersonalProjectApplication personalProjectApplication;

    @Autowired
    MngThreadsToHandleSpecificCar mngThreadsToHandleSpecificCar;


    /**
     *
     * @param aVin
     * @return uniq Vehicle
     */
    @RequestMapping(path  = Constants.FIND_VEHICLES_BY_VIN, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPersonByVin(@PathVariable("vin") String aVin){

        return new ResponseEntity<>(personalProjectApplication.vehicleRepositoryGlobal.findVehicleByVin(aVin), HttpStatus.OK);

    }


    /**
     *
     * @param aManufacture
     * @return Vehicles
     */
    @RequestMapping(path  = Constants.FIND_VEHICLES_BY_MANUFACTURE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getVehiclesByManufacture(@RequestParam(Constants.MANUFACTURE) String aManufacture){

        return new ResponseEntity<>(personalProjectApplication.vehicleRepositoryGlobal.findVehiclesByManufacture(aManufacture), HttpStatus.OK);

    }


    /**
     *
     * @param aModelName
     * @return Vehicles
     */
    @RequestMapping(path  = Constants.FIND_VEHICLES_BY_MODEL_NAME, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getVehiclesByModelName(@RequestParam(Constants.MODEL_NAME) String aModelName){

        return new ResponseEntity<>(personalProjectApplication.vehicleRepositoryGlobal.findVehiclesByModelName(aModelName), HttpStatus.OK);

    }


    /**
     * Check wheel of cars
     * @return Void
     */
    @RequestMapping(path  = Constants.CHECK_WHEELS_OF_CARS, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> checkWheelsOfCar(){
        mngThreadsToHandleSpecificCar.MngThreadsToHandleSpecificCar();
        return new ResponseEntity<>("Wheels were checked in successfuly  :-) ", HttpStatus.OK);
    }
}