package com.vkgames.football.mongo.service.person;

import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.role.Role;

import java.util.List;

public interface PersonService {

    Person createPerson(PersonRequestDto personRequestDto);

    Person getPersonByIdAndRole(String id, Role role);

    Person updatePerson(String id, Role role, PersonRequestDto personRequestDto);

    void deletePerson(String id, Role role);

    Person getPersonByRoleAndName(Role role, String name);

    List<Person> getAll(Role role);
}
