package com.vkgames.football.mongo.service.person.personStorageService;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.role.Role;

import java.util.List;

public interface PersonStorageService {
    void savePerson(Person person);

    Person findPerson(String id);

    void deletePerson(String id);

    Person findPersonByNameAndRole(String name);

    List<Person> getAll(Role role);


}
