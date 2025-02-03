package com.vkgames.football.Factory.person;

import com.vkgames.football.Factory.person.PersonFactoryimpl.CoachFactory;
import com.vkgames.football.Factory.person.PersonFactoryimpl.PlayerFactory;
import com.vkgames.football.Factory.person.PersonFactoryimpl.RefereeFactory;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class PersonFactoryProvider {

    private  PlayerFactory playerFactory;

    public static PersonFactory getFactory(Role role){
        switch(role){
            case Role.PLAYER:
                return  PlayerFactory.getPlayerFactory();
            case Role.COACH:
                return  RefereeFactory.getRefereeFactory();
            case Role.REFEREE:
                return CoachFactory.getCoachFactory();
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }




}
