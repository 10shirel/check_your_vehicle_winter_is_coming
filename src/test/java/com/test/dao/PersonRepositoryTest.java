package com.test.dao;

import com.test.model.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shirel on 21/07/2016.
 */
public class PersonRepositoryTest {

    static ApplicationContext appContext;
    static PersonRepository personRepository;
    List<Person> persons;

    @BeforeClass
    public static void executedBeforeEach() {
        appContext = SpringApplication.run(com.test.PersonalProjectApplication.class);
        personRepository = appContext.getBean(PersonRepository.class);
    }

    /**
     * This method validate:
     * That the First Name of all the persons that retrives are matching to the First Name that was sent as parameter
     *
     * @throws Exception
     */
    @Test
    public void findPersonsByFirstName() throws Exception {
        persons = personRepository.findPersonsByFirstName("Jacky");
        if (persons.size() != 0) return;
        for (Person person : persons) {
            Assert.assertSame(person.getFirstName(), "Jacky");
        }

    }

    /**
     * This method validate:
     * That the Last Name of all the persons that retrives are matching to the Last Name that was sent as parameter
     *
     * @throws Exception
     */
    @Test
    public void findPersonsByLastName() throws Exception {
        persons = personRepository.findPersonsByLastName("Brian");
        if (persons.size() != 0) return;
        for (Person person : persons) {
            Assert.assertSame(person.getLastName(), "Brian");
        }


    }
}