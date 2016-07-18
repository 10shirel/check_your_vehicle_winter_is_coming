package com.test;

import com.test.dao.PersonRepository;
import com.test.dao.VehicleRepository;
import com.test.model.Person;
import com.test.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PersonalProjectApplication {
private static final Logger log = LoggerFactory.getLogger(PersonalProjectApplication.class);


	public PersonRepository personRepositoryGlobal;
	public VehicleRepository vehicleRepositoryGlobal;

	public static void main(String[] args) {
		SpringApplication.run(PersonalProjectApplication.class, args);
	}

	/**
	 * Populate data to h2 DB  - Persons and Vehicles
	 * @param personRepository
	 * @param vehicleRepository
     * @return
     */
	@Bean
	public CommandLineRunner populateData(PersonRepository personRepository, VehicleRepository vehicleRepository) {
		return (args) -> {
			// save a couple of Vehicles
			vehicleRepositoryGlobal = vehicleRepository;

			vehicleRepository.save(new Vehicle("11-111-11", "Opel", "Astra"));
			vehicleRepository.save(new Vehicle("22-222-22", "Citroen", "C4"));
			vehicleRepository.save(new Vehicle("33-333-33", "Citroen", "C1"));
			vehicleRepository.save(new Vehicle("44-444-44", "BMW", "AX"));
			vehicleRepository.save(new Vehicle("55-555-55", "Citroen", "AX"));


			// save a couple of Persons
			personRepositoryGlobal = personRepository;

			personRepositoryGlobal.save(new Person("Jacky", "Lev", "11-111-11"));
			personRepositoryGlobal.save(new Person("Chloe", "Brian", "22-222-22"));
			personRepositoryGlobal.save(new Person("Kim", "Agy1", "33-333-33"));
			personRepositoryGlobal.save(new Person("Kim", "Agy2", "44-444-44"));
			personRepositoryGlobal.save(new Person("David", "Vider", "55-555-55"));
			personRepositoryGlobal.save(new Person("David", "Boy", "66-666-66"));
			personRepositoryGlobal.save(new Person("Ben", "Bony", "77-777-77"));



		};
	}

}
