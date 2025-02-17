package com.vkgames.football.elastic.factory.personFactoryImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EReferee;
import com.vkgames.football.elastic.factory.EPersonFactory;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ERefereeFactory implements EPersonFactory {
    @Override
    public EPerson createEPerson(PersonRequestDto personRequestDto) {
        EReferee eReferee = new EReferee();
        eReferee.setName(personRequestDto.getName());
        eReferee.setAge(personRequestDto.getAge());
        eReferee.setRole(personRequestDto.getRole());
        return eReferee;


    }
}
