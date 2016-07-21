package com.checkvehicle.handlevehicle;


import com.checkvehicle.PersonalProjectApplication;
import com.checkvehicle.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Scope("prototype")
/**
 * A bean that is responsible for do the job for single record
 */
public class MngThreadsToHandleSpecificCar {

private static final Logger LOGGER = LoggerFactory.getLogger(MngThreadsToHandleSpecificCar.class);


@Autowired
private ApplicationContext appContext;

@Autowired
private PersonalProjectApplication personalProjectApplication;


private static final int MAX_THREADS = 3;
private static final int MAX_WAIT_MINUTES = 10;

    public MngThreadsToHandleSpecificCar() {
    }

    public void MngThreadsToHandleSpecificCar() {

        ExecutorService executor = null;
        try {
            executor = Executors.newFixedThreadPool(MAX_THREADS);
            for (Vehicle vehicle : personalProjectApplication.vehicleRepositoryGlobal.findAll()) {
                SpecificInstanceToHandleCarActions specificInstanceToHandleCarActions = appContext.getBean(SpecificInstanceToHandleCarActions.class);
                specificInstanceToHandleCarActions.setVehicle(vehicle);
                executor.execute(specificInstanceToHandleCarActions);
            }
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }


        try {
            if (executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                LOGGER.debug("The task was completed in time\n" + " Result: " );
            } else {
                LOGGER.error("The task was unable to complete in {} minutes", MAX_WAIT_MINUTES);
            }
        } catch (InterruptedException e) {
            LOGGER.error("The task was interrupted", e);
        }


    }

    }
