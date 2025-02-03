package com.vkgames.football.Service.Person.PersonUpdateService;

import com.vkgames.football.Entity.Person.Person;

public interface PersonUpdateService {
    Person updatePersonService(Person oldPerson, Person newPerson);
}
