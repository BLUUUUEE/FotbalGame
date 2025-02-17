package com.vkgames.football.mongo.service.person.personServiceImpl;

import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.factory.person.PersonFactory;
import com.vkgames.football.mongo.factory.person.PersonFactoryProvider;
import com.vkgames.football.mongo.service.person.PersonService;
import com.vkgames.football.mongo.service.person.personStorageService.PersonStorageService;
import com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl.CoachStorageService;
import com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl.PlayerStorageService;
import com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl.RefereeStorageService;
import com.vkgames.football.mongo.service.person.personUpdateService.PersonUpdateService;
import com.vkgames.football.mongo.service.person.personUpdateService.personUpdateServiceImpl.CoachUpdateService;
import com.vkgames.football.mongo.service.person.personUpdateService.personUpdateServiceImpl.PlayerUpdateService;
import com.vkgames.football.mongo.service.person.personUpdateService.personUpdateServiceImpl.RefereeUpdateService;
import com.vkgames.football.role.Role;
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

    public Person getPersonByIdAndRole(String id, Role role) {
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

    public Person updatePerson(String id, Role role, PersonRequestDto personRequestDto) {
        PersonStorageService personStorageService = getPersonStorageService(role);
        Person oldPerson = personStorageService.findPerson(id);
        PersonFactory personFactory = personFactoryProvider.getFactory(personRequestDto.getRole());
        Person newPerson = personFactory.createPerson(personRequestDto);

        PersonUpdateService personUpdateService = getUpdateService(personRequestDto.getRole());
        oldPerson = personUpdateService.updatePersonService(oldPerson, newPerson);
        personStorageService.savePerson(oldPerson);
        return oldPerson;

    }

    public void deletePerson(String id, Role role) {
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
