package com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl;

import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Player;
import com.vkgames.football.mongo.repository.person.PlayerRepository;
import com.vkgames.football.role.Role;
import com.vkgames.football.mongo.service.person.personStorageService.PersonStorageService;
import com.vkgames.football.mongo.service.stats.statsServiceImpl.PlayerStatsService;
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

       Player player = (Player)person;
       player.setId( IdGenerator.generateIdForPlayer(player.getName(),player.getTeam(),player.getJerseyNumber()));
        playerRepository.save(player);

        System.out.println("Player saved!!");

    }

    @Override
    public Person findPerson(String id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return player.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(String id) {
        Optional<Player> player = playerRepository.findById(id);

       if(player.isPresent()){
           playerStatsService.deletePlayerStats(player.get().getPlayerStatsId());
           playerRepository.deleteById(player.get().getPlayerStatsId());

       }
        playerRepository.deleteById(id);
//        playerElasticRepository.deleteById(id);

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
