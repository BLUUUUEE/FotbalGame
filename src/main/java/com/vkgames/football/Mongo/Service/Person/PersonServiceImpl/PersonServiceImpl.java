package com.vkgames.football.Mongo.Service.Person.PersonServiceImpl;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Factory.person.PersonFactory;
import com.vkgames.football.Mongo.Factory.person.PersonFactoryProvider;
import com.vkgames.football.Mongo.Service.Person.PersonService;
import com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageService;
import com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.CoachStorageService;
import com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.PlayerStorageService;
import com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.RefereeStorageService;
import com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateService;
import com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.CoachUpdateService;
import com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.PlayerUpdateService;
import com.vkgames.football.Mongo.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.RefereeUpdateService;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PlayerStorageService playerStorageService;
    @Autowired
    private CoachStorageService coachStorageService;
    @Autowired
    private RefereeStorageService refereeStorageService;
    @Autowired
    private CoachUpdateService coachUpdateService;
    @Autowired
    private RefereeUpdateService refereeUpdateService;
    @Autowired
    private PlayerUpdateService playerUpdateService;

    @Autowired
    private PersonFactoryProvider personFactoryProvider;

    public Person createPerson(PersonRequestDto personRequestDto) {
        PersonFactory personFactory = personFactoryProvider.getFactory(personRequestDto.getRole());
        Person person = personFactory.createPerson(personRequestDto);

        PersonStorageService personStorageService = getPersonStorageService(personRequestDto.getRole());
        personStorageService.savePerson(person);

        return person;
    }

    public Person getPersonByIdAndRole(ObjectId id, Role role) {
        PersonStorageService personStorageService = getPersonStorageService(role);

        return personStorageService.findPerson(id);
    }

    public Person getPersonByRoleAndName(Role role, String name) {
        PersonStorageService personStorageService = getPersonStorageService(role);
        return personStorageService.findPersonByNameAndRole(name);
    }

    @Override
    public List<Person> getAll(Role role) {
        PersonStorageService personStorageService = getPersonStorageService(role);
        return personStorageService.getAll(role);
    }

    public Person updatePerson(ObjectId id, Role role, PersonRequestDto personRequestDto) {
        PersonStorageService personStorageService = getPersonStorageService(role);
        Person oldPerson = personStorageService.findPerson(id);
        PersonFactory personFactory = personFactoryProvider.getFactory(personRequestDto.getRole());
        Person newPerson = personFactory.createPerson(personRequestDto);

        PersonUpdateService personUpdateService = getUpdateService(personRequestDto.getRole());
        oldPerson = personUpdateService.updatePersonService(oldPerson, newPerson);
        personStorageService.savePerson(oldPerson);
        return oldPerson;

    }

    public void deletePerson(ObjectId id, Role role) {
        PersonStorageService personStorageService = getPersonStorageService(role);

        if (personStorageService != null) {
            personStorageService.deletePerson(id);
        }

    }

    private PersonStorageService getPersonStorageService(Role role) {
        switch (role) {
            case PLAYER:
                return playerStorageService;
            case REFEREE:
                return refereeStorageService;
            case COACH:
                return coachStorageService;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }


    }


    private PersonUpdateService getUpdateService(Role role) {
        switch (role) {
            case PLAYER:
                return playerUpdateService;
            case REFEREE:
                return refereeUpdateService;
            case COACH:
                return coachUpdateService;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }


}
