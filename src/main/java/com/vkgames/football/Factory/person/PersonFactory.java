package com.vkgames.football.Factory.person;

import com.vkgames.football.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;

public interface PersonFactory {
    Person createPerson(PersonRequestDto personRequestDto);
}
