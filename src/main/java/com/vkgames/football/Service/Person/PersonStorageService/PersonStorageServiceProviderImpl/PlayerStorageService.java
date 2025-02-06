package com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Repository.Person.PlayerRepository;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageService;
import com.vkgames.football.Service.Stats.StatsServiceImpl.PlayerStatsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerStorageService implements PersonStorageService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerStatsService playerStatsService;

    @Override
    public void savePerson(Person person) {

        playerRepository.save((Player)person);
        System.out.println("Player saved!!");

    }

    @Override
    public Person findPerson(ObjectId id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return player.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(ObjectId id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Person findPersonByNameAndRole(String name) {
        return (Person) playerRepository.findByName(name);
    }

    @Override
    public List<Person> getAll(Role role) {
        List<Player> playerList = playerRepository.findAll();
        List<Person> personList = null;
        for (Player p : playerList) {
            personList.add((Person) p);
        }
        return personList;
    }
}
