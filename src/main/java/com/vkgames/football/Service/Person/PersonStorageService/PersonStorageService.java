package com.vkgames.football.Service.Person.PersonStorageService;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface PersonStorageService {
    void savePerson(Person person);

    Person findPerson(ObjectId id);

    void deletePerson(ObjectId id);

    Person findPersonByNameAndRole(String name);

    List<Person> getAll(Role role);


}
