package com.test.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shirel on 20/07/2016.
 */
public class PersonTest {
    @Test
    public void person() {
        Person person = new Person(1000,"PersonFirstName","PersonLastName","99-999-99");
        Assert.assertEquals("Person{id=1000_firstName=PersonFirstName_lastName=PersonLastName_vinNumber=99-999-99}",person.toString());
     }

    @Test
    public void personWithoutId() {
        Person person = new Person("PersonFirstName","PersonLastName","99-999-99");
        Assert.assertEquals("Person{id=0_firstName=PersonFirstName_lastName=PersonLastName_vinNumber=99-999-99}",person.toString());
     }

}