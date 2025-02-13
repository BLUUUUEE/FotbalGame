package com.vkgames.football.Mongo.Factory.person;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;

public interface PersonFactory {
    Person createPerson(PersonRequestDto personRequestDto);
}
