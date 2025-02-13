package com.vkgames.football.Elastic.EFactory.EPersonFactoryImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EReferee;
import com.vkgames.football.Elastic.EFactory.EPersonFactory;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
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
