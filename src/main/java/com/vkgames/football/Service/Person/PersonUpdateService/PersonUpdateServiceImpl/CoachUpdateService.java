package com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Coach;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class CoachUpdateService implements PersonUpdateService {


    @Override
    public Person updatePersonService(Person oldPerson, Person newPerson) {
        Coach oldCoach = (Coach) oldPerson;
        Coach newCoach = (Coach) newPerson;

        oldCoach.setName(newCoach.getName() != null ? newCoach.getName() : oldCoach.getName());
        oldCoach.setAge(Math.max(newCoach.getAge(), oldCoach.getAge()));
        oldCoach.setTeam(newCoach.getTeam() != null ? newCoach.getTeam() : oldCoach.getTeam());

        System.out.println("coach updated");
        return (Person) oldCoach;

    }
}
