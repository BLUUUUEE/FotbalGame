package com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.ECoach;
import com.vkgames.football.Elastic.EFactory.EPersonFactory;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ECoachFactory implements EPersonFactory {
    @Override
    public EPerson createEPerson(PersonRequestDto personRequestDto) {
        ECoach eCoach = new ECoach();
        eCoach.setName(personRequestDto.getName());
        eCoach.setAge(personRequestDto.getAge());
        eCoach.setTeam(personRequestDto.getTeam());
        eCoach.setRole(personRequestDto.getRole());

        return eCoach;
    }
}
