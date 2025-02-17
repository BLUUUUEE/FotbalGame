package com.vkgames.football.elastic.factory.personFactoryImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.ECoach;
import com.vkgames.football.elastic.factory.EPersonFactory;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ECoachFactory implements EPersonFactory {

    @Override
    public EPerson  createEPerson(PersonRequestDto personRequestDto) {
        ECoach eCoach = new ECoach();
        eCoach.setName(personRequestDto.getName());
        eCoach.setAge(personRequestDto.getAge());
        eCoach.setTeam(personRequestDto.getTeam());
        eCoach.setRole(personRequestDto.getRole());

        return eCoach;
    }
}
