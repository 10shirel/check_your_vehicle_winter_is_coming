package com.checkvehicle.dao;

/**
 * Created by shirel on 11/07/2016.
 */

import java.util.List;

import com.checkvehicle.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findPersonsByFirstName(String firstName);
    List<Person> findPersonsByLastName(String lastName);
}