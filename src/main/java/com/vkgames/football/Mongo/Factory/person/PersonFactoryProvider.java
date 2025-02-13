package com.vkgames.football.Mongo.Factory.person;

import com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl.CoachFactory;
import com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl.PlayerFactory;
import com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl.RefereeFactory;
import com.vkgames.football.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonFactoryProvider {

    @Autowired
    private PlayerFactory playerFactory;

    @Autowired
    private RefereeFactory refereeFactory;

    @Autowired
    private CoachFactory coachFactory;

    public PersonFactory getFactory(Role role) {
        switch (role) {
            case PLAYER:
                return playerFactory;
            case COACH:
                return coachFactory;
            case REFEREE:
                return refereeFactory;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

    }


}
