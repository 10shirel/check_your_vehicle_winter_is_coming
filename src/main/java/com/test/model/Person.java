package com.test.model;

/**
 * Created by shirel on 11/07/2016.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String vinNumber;


    protected Person() {}

    public Person(String firstName, String lastName, String vinNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vinNumber = vinNumber;
    }


    public Person(long id, String firstName, String lastName, String vinNumber) {
        this(firstName, lastName, vinNumber);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                "_firstName=" + firstName +
                "_lastName=" + lastName +
                "_vinNumber=" + vinNumber +
                '}';
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }


}
