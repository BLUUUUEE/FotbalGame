package com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateServiceImpl;

import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateService;
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

        oldPlayer.setDribbling(Math.max(oldPlayer.getDribbling(), newPlayer.getDribbling()));
        oldPlayer.setPace(Math.max(oldPlayer.getPace(), newPlayer.getPace()));
        oldPlayer.setDefending(Math.max(oldPlayer.getDefending(), newPlayer.getDefending()));
        oldPlayer.setPassing(Math.max(oldPlayer.getPassing(), newPlayer.getPassing()));
        oldPlayer.setPhysicality(Math.max(oldPlayer.getPhysicality(), newPlayer.getPhysicality()));
        oldPlayer.setShooting(Math.max(oldPlayer.getShooting(), newPlayer.getShooting()));

        System.out.println("player updated!!");
        return (Person) oldPlayer;
    }
}
