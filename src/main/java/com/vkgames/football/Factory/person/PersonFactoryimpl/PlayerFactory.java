package com.vkgames.football.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Factory.person.PersonFactory;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Service.Stats.StatsServiceImpl.PlayerStatsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlayerFactory implements PersonFactory {


    @Autowired
    private PlayerStatsService playerStatsService;

//    private static PlayerFactory playerFactory;

//    private PlayerFactory() {
//
//    }
//
//
//
//    public static PlayerFactory getPlayerFactory() {
//        if (playerFactory == null) {
//            playerFactory = new PlayerFactory();
//        }
//        return playerFactory;
//    }


    public Person createPerson(PersonRequestDto personRequestDto) {
        Player player = new Player();
        ObjectId playerStatsId = playerStatsService.createPlayerStats(personRequestDto.getName());
        player.setName(personRequestDto.getName());
        player.setPlayerStatsId(playerStatsId);
        player.setAge(personRequestDto.getAge());
        player.setTeam(personRequestDto.getTeam());
        player.setPosition(personRequestDto.getPosition());
        player.setJerseyNumber(personRequestDto.getJerseyNumber());
        player.setRole(Role.PLAYER);
        player.setPace(personRequestDto.getPace());
        player.setPhysicality(personRequestDto.getPhysicality());
        player.setShooting(personRequestDto.getShooting());
        player.setPassing(personRequestDto.getPassing());
        player.setDefending(personRequestDto.getDefending());
        player.setDribbling(personRequestDto.getDribbling());


        return player;

    }
}
