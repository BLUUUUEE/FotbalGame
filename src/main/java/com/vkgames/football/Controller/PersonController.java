package com.vkgames.football.Controller;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EService.EPerson.EPersonService;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Service.Person.PersonService;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private EPersonService ePersonService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody PersonRequestDto personRequestDto) {

        personService.createPerson(personRequestDto);
        EPerson ePerson = ePersonService.createEPerson(personRequestDto);

        return new ResponseEntity<>(ePerson, HttpStatus.OK);

    }

    @GetMapping("/id/{personId}/{role}")
    public ResponseEntity<?> getPersonByIdAndRole(@PathVariable ObjectId personId, @PathVariable Role role) {

        EPerson ePerson = ePersonService.getEPersonByIdAndRole(personId.toString(), role);
        System.out.println(ePerson);

        if (ePerson != null) {
            return new ResponseEntity<>(ePerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{role}")
    public ResponseEntity<?> getAll(@PathVariable Role role) {
        List<EPerson> allPerson = ePersonService.getAll(role);
        if (allPerson != null) {
            return new ResponseEntity<>(allPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{role}/{personName}")
    public ResponseEntity<?> getPersonByRoleAndName(@PathVariable Role role, @PathVariable String personName) {
        EPerson ePerson = ePersonService.getEPersonByRoleAndName(role, personName);
        if (ePerson != null) {
            return new ResponseEntity<>(ePerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{personId}/{personRole}")
    public void deletePersonById(@PathVariable ObjectId personId, @PathVariable Role personRole) {
        personService.deletePerson(personId, personRole);
        ePersonService.deleteEPerson(personId.toString(), personRole);
    }

    @PutMapping("id/{personId}/{role}")
    public ResponseEntity<?> updatePerson(@PathVariable ObjectId personId, @PathVariable Role role, @RequestBody PersonRequestDto personRequestDto) {
        personService.updatePerson(personId, role, personRequestDto);
        EPerson ePerson = ePersonService.updateEPerson(personId.toString(), role, personRequestDto);
        if (ePerson != null) {
            return new ResponseEntity<>(ePerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
