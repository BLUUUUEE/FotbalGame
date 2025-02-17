package com.vkgames.football.elastic.factory;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;

public interface EPersonFactory {
    EPerson createEPerson(PersonRequestDto personRequestDto);
}
