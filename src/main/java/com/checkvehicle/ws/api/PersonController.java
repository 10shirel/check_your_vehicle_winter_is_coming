package com.checkvehicle.ws.api;

import com.checkvehicle.PersonalProjectApplication;
import com.checkvehicle.model.Person;
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
@RequestMapping(Constants.API_PERSONS)
public class PersonController {




    private ResponseEntity responseEntity;

    @Autowired
    PersonalProjectApplication personalProjectApplication;

    /**
     *
     * @param aId
     * @return uniq Person
     */
    @RequestMapping(path  = Constants.FIND_PERSON_BY_ID, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPersonById(@PathVariable(Constants.ID) long aId){

        return new ResponseEntity<>(personalProjectApplication.personRepositoryGlobal.findOne(aId), HttpStatus.OK);

    }

    /**
     *
     * @param aFirstName
     * @return Persons
     */
    @RequestMapping(path  = Constants.FIND_PERSONS_BY_FIRST_NAME, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getPersonsByFirstName(@RequestParam(Constants.FIRST_NAME) String aFirstName){

        return new ResponseEntity<>(personalProjectApplication.personRepositoryGlobal.findPersonsByFirstName(aFirstName), HttpStatus.OK);

    }

    /**
     *
     * @param aLastName
     * @return Persons
     */
    @RequestMapping(path  = Constants.FIND_PERSONS_BY_LAST_NAME,method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getPersonsByLastName(@RequestParam(Constants.LAST_NAME) String aLastName){

        return new ResponseEntity<>(personalProjectApplication.personRepositoryGlobal.findPersonsByLastName(aLastName), HttpStatus.OK);

    }

}
