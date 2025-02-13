package com.vkgames.football.Elastic.EFactory;

import com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl.ECoachFactory;
import com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl.EPlayerFactory;
import com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl.ERefereeFactory;
import com.vkgames.football.Role.Role;
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
