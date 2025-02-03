package com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Repository.PlayerRepository;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStorageService implements PersonStorageService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void savePerson(Person person) {
        Player player = (Player) person;
        playerRepository.save(player);
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
}
