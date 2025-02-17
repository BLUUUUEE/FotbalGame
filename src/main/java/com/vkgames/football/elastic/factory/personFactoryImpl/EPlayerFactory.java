package com.vkgames.football.elastic.factory.personFactoryImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.factory.EPersonFactory;
import com.vkgames.football.elastic.service.stats.statsServiceImpl.EPlayerStatsService;
import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EPlayerFactory implements EPersonFactory {

    @Autowired
private EPlayerStatsService ePlayerStatsService;

    @Override
    public EPerson createEPerson(PersonRequestDto personRequestDto) {

        EPlayer ePlayer = new EPlayer();
         ePlayerStatsService.createEPlayerStats(personRequestDto.getName(),
                                                 personRequestDto.getAge(),
                                                 personRequestDto.getPosition());

        ePlayer.setName(personRequestDto.getName());
        ePlayer.setEplayerStatsId(IdGenerator.generateIdForPlayerStats(personRequestDto.getName(),
                                                                    personRequestDto.getAge(),
                                                                    personRequestDto.getPosition()));
        ePlayer.setAge(personRequestDto.getAge());
        ePlayer.setTeam(personRequestDto.getTeam());
        ePlayer.setPosition(personRequestDto.getPosition());
        ePlayer.setJerseyNumber(personRequestDto.getJerseyNumber());
        ePlayer.setRole(Role.PLAYER);
        ePlayer.setPace(personRequestDto.getPace());
        ePlayer.setPhysicality(personRequestDto.getPhysicality());
        ePlayer.setShooting(personRequestDto.getShooting());
        ePlayer.setPassing(personRequestDto.getPassing());
        ePlayer.setDefending(personRequestDto.getDefending());
        ePlayer.setDribbling(personRequestDto.getDribbling());



        return ePlayer;
    }
}
