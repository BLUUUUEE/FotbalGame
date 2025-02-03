package com.vkgames.football.Service.Person.PersonStorageService;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

public interface  PersonStorageService {
    void savePerson(Person person);

    Person findPerson(ObjectId id);

    void deletePerson(ObjectId id);




}
