package com.vkgames.football.Factory.person;

import com.vkgames.football.Factory.person.PersonFactoryimpl.CoachFactory;
import com.vkgames.football.Factory.person.PersonFactoryimpl.PlayerFactory;
import com.vkgames.football.Factory.person.PersonFactoryimpl.RefereeFactory;
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
            case Role.PLAYER:
                return playerFactory;
            case Role.COACH:
                return coachFactory;
            case Role.REFEREE:
                return refereeFactory;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }


}
