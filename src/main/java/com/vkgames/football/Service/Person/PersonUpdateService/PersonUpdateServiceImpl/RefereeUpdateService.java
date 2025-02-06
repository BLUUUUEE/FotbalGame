package com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Referee;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class RefereeUpdateService implements PersonUpdateService {


    @Override
    public Person updatePersonService(Person oldPerson, Person newPerson) {
        Referee newRef = (Referee) oldPerson;
        Referee oldRef = (Referee) newPerson;

        oldRef.setName(newRef.getName() != null ? newRef.getName() : oldRef.getName());
        oldRef.setAge(Math.max(oldRef.getAge(), newRef.getAge()));

        System.out.println("referee updated!!");
        return (Person) oldRef;


    }
}
