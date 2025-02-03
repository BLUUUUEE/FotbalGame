package com.vkgames.football.Service.Person;

import com.vkgames.football.Dto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

public interface PersonService {

    Person createPerson(PersonRequestDto personRequestDto);

    Person getPersonByIdAndRole(ObjectId id,Role role);

    Person updatePerson(ObjectId id,Role role, PersonRequestDto personRequestDto);

    void deletePerson(ObjectId id, Role role);


}
