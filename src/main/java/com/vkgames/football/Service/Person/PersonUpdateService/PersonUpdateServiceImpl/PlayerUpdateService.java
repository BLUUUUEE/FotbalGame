package com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class PlayerUpdateService implements PersonUpdateService {


    @Override
    public Person updatePersonService(Person oldPerson, Person newPerson) {
        Player oldPlayer = (Player) oldPerson;
        Player newPlayer = (Player) newPerson;

        oldPlayer.setName(newPlayer.getName() != null
                ? newPlayer.getName()
                : oldPlayer.getName());
//        System.out.println(oldPlayer.getName());
        oldPlayer.setAge(Math.max(newPlayer.getAge(), oldPlayer.getAge()));
        oldPlayer.setTeam(newPlayer.getTeam() != null
                ? newPlayer.getTeam()
                : oldPlayer.getTeam());

        System.out.println(oldPlayer.getTeam());
        oldPlayer.setPosition(newPlayer.getPosition() != null
                ? newPlayer.getPosition()
                : oldPlayer.getPosition());
        oldPlayer.setJerseyNumber(newPlayer.getJerseyNumber() > 0
                ? newPlayer.getJerseyNumber()
                : oldPlayer.getJerseyNumber());

        System.out.println("player updated!!");
        return (Person) oldPlayer;
    }
}
