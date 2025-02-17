package com.vkgames.football.mongo.service.person.personUpdateService;

import com.vkgames.football.mongo.entity.person.Person;

public interface PersonUpdateService {
    Person updatePersonService(Person oldPerson, Person newPerson);
}
