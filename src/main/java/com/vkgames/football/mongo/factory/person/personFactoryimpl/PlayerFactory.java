package com.vkgames.football.mongo.factory.person.personFactoryimpl;

import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Player;
import com.vkgames.football.mongo.factory.person.PersonFactory;
import com.vkgames.football.mongo.service.stats.statsServiceImpl.PlayerStatsService;
import com.vkgames.football.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlayerFactory implements PersonFactory {


    @Autowired
    private PlayerStatsService playerStatsService;


    public Person createPerson(PersonRequestDto personRequestDto) {
        Player player = new Player();
        String playerStatsId = playerStatsService.createPlayerStats(personRequestDto.getName(),personRequestDto.getAge(),personRequestDto.getPosition());
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
