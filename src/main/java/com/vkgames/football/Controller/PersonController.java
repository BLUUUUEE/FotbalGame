package com.vkgames.football.Controller;

import com.vkgames.football.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Repository.Stats.PlayerStatsRepository;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Service.Person.PersonService;
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

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody PersonRequestDto personRequestDto) {

        Person person = personService.createPerson(personRequestDto);

        return new ResponseEntity<>(person, HttpStatus.OK);

    }

    @GetMapping("/id/{personId}/{role}")
    public ResponseEntity<?> getPersonByIdAndRole(@PathVariable ObjectId personId, @PathVariable Role role) {

        Person person = personService.getPersonByIdAndRole(personId, role);
        System.out.println(person);

        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{role}")
    public ResponseEntity<?> getAll(@PathVariable Role role) {
        List<Person> allPerson = personService.getAll(role);
        if (allPerson != null) {
            return new ResponseEntity<>(allPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{role}/{personName}")
    public ResponseEntity<?> getPersonByRoleAndName(@PathVariable Role role, @PathVariable String personName) {
        Person person = personService.getPersonByRoleAndName(role, personName);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{personId}/{personRole}")
    public void deletePersonById(@PathVariable ObjectId personId, @PathVariable Role personRole) {
        personService.deletePerson(personId, personRole);
    }

    @PutMapping("id/{personId}/{role}")
    public ResponseEntity<?> updatePerson(@PathVariable ObjectId personId, @PathVariable Role role, @RequestBody PersonRequestDto personRequestDto) {
        Person person = personService.updatePerson(personId, role, personRequestDto);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
