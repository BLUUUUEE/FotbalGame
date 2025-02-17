package com.vkgames.football.mongo.factory.person;

import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;

public interface PersonFactory {
    Person createPerson(PersonRequestDto personRequestDto);
}
