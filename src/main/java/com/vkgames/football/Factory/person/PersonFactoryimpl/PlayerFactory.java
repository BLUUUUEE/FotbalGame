package com.vkgames.football.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Dto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import com.vkgames.football.Factory.person.PersonFactory;
import com.vkgames.football.Role.Role;

public class PlayerFactory implements PersonFactory {

    private static PlayerFactory playerFactory;
    private PlayerFactory(){};

    public static PlayerFactory getPlayerFactory(){
        if(playerFactory==null){
            playerFactory = new PlayerFactory();
        }
        return playerFactory;
    }


    public Person createPerson(PersonRequestDto personRequestDto) {
       Player player = new Player();
       player.setName(personRequestDto.getName());
       player.setAge(personRequestDto.getAge());
       player.setTeam(personRequestDto.getTeam());
       player.setPosition(personRequestDto.getPosition());
       player.setJerseyNumber(personRequestDto.getJerseyNumber());
       player.setRole(Role.PLAYER);

       return player;

    }
}
