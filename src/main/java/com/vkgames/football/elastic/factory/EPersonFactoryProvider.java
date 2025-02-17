package com.vkgames.football.elastic.factory;

import com.vkgames.football.elastic.factory.personFactoryImpl.ECoachFactory;
import com.vkgames.football.elastic.factory.personFactoryImpl.EPlayerFactory;
import com.vkgames.football.elastic.factory.personFactoryImpl.ERefereeFactory;
import com.vkgames.football.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EPersonFactoryProvider {

    @Autowired
    private EPlayerFactory ePlayerFactory;

    @Autowired
    private ERefereeFactory eRefereeFactory;

    @Autowired
    private ECoachFactory eCoachFactory;

    public EPersonFactory getEFactory(Role role) {
        switch (role) {
            case PLAYER:
                return ePlayerFactory;
            case COACH:
                return eCoachFactory;
            case REFEREE:
                return eRefereeFactory;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

    }


}
