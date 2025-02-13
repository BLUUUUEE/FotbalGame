package com.vkgames.football.Mongo.Service.Person;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface PersonService {

    Person createPerson(PersonRequestDto personRequestDto);

    Person getPersonByIdAndRole(ObjectId id, Role role);

    Person updatePerson(ObjectId id, Role role, PersonRequestDto personRequestDto);

    void deletePerson(ObjectId id, Role role);

    Person getPersonByRoleAndName(Role role, String name);

    List<Person> getAll(Role role);
}
