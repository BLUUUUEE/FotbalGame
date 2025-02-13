package com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EPlayer;
import com.vkgames.football.Elastic.EFactory.EPersonFactory;
import com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl.EPlayerStatsService;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EPlayerFactory implements EPersonFactory {

    @Autowired
private EPlayerStatsService ePlayerStatsService;

    @Override
    public EPerson createEPerson(PersonRequestDto personRequestDto) {

        EPlayer ePlayer = new EPlayer();
        String playerStatsId = ePlayerStatsService.createEPlayerStats(personRequestDto.getName());
        ePlayer.setName(personRequestDto.getName());
        ePlayer.setEplayerStatsId(playerStatsId);
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
