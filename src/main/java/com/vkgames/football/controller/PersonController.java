package com.vkgames.football.controller;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.service.person.EPersonService;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.service.person.PersonService;
import com.vkgames.football.role.Role;
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

        Person person = personService.createPerson(personRequestDto);
        ePersonService.createEPerson(personRequestDto);

        return new ResponseEntity<>(person, HttpStatus.OK);

    }

    @GetMapping("id/{personId}/{role}")
    public ResponseEntity<?> getPersonByIdAndRole(@PathVariable String personId, @PathVariable Role role) {

        EPerson ePerson = ePersonService.getEPersonByIdAndRole(personId, role);
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
    public void deletePersonById(@PathVariable String personId, @PathVariable Role personRole) {
        personService.deletePerson(personId, personRole);
        ePersonService.deleteEPerson(personId.toString(), personRole);
    }

    @PutMapping("id/{personId}/{role}")
    public ResponseEntity<?> updatePerson(@PathVariable String personId, @PathVariable Role role, @RequestBody PersonRequestDto personRequestDto) {
        personService.updatePerson(personId, role, personRequestDto);
        EPerson ePerson = ePersonService.updateEPerson(personId.toString(), role, personRequestDto);
        if (ePerson != null) {
            return new ResponseEntity<>(ePerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("players/{teamName}")
    public ResponseEntity<?> getAllPlayersOfTeam(@PathVariable String teamName) {
        List<EPlayer> ePlayers = ePersonService.getAllPlayersOfTeam(teamName);
        if (!ePlayers.isEmpty()) {
            return new ResponseEntity<>(ePlayers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/player")
//    public ResponseEntity<?>getPlayerWithMaxGoals(){
//        EPlayerStats ePlayerStats = ePersonService.playerWithMaxGoals();
//        if(ePlayerStats!=null){
//            return new ResponseEntity<>(ePlayerStats,HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
