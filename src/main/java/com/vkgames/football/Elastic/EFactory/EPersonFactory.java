package com.vkgames.football.Elastic.EFactory;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;

public interface EPersonFactory {
    EPerson createEPerson(PersonRequestDto personRequestDto);
}
