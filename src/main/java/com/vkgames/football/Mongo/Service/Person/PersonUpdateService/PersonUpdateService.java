package com.vkgames.football.Mongo.Service.Person.PersonUpdateService;

import com.vkgames.football.Mongo.Entity.Person.Person;

public interface PersonUpdateService {
    Person updatePersonService(Person oldPerson, Person newPerson);
}
