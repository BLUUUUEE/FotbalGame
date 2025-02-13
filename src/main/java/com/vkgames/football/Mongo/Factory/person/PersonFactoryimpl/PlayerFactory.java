package com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Mongo.Factory.person.PersonFactory;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Mongo.Service.Stats.StatsServiceImpl.PlayerStatsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlayerFactory implements PersonFactory {


    @Autowired
    private PlayerStatsService playerStatsService;




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
