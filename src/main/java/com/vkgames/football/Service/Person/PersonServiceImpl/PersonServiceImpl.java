package com.vkgames.football.Service.Person.PersonServiceImpl;

import com.vkgames.football.Dto.PersonRequestDto;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Factory.person.PersonFactory;
import com.vkgames.football.Factory.person.PersonFactoryProvider;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Service.Person.PersonService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.CoachStorageService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.PlayerStorageService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.RefereeStorageService;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateService;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.CoachUpdateService;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.PlayerUpdateService;
import com.vkgames.football.Service.Person.PersonUpdateService.PersonUpdateServiceImpl.RefereeUpdateService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Person createPerson(PersonRequestDto personRequestDto) {
        PersonFactory personFactory = PersonFactoryProvider.getFactory(personRequestDto.getRole());
        Person person = personFactory.createPerson(personRequestDto);
        PersonStorageService personStorageService = getPersonStorageService(personRequestDto.getRole());
        personStorageService.savePerson(person);
        return person;
    }

    public Person getPersonByIdAndRole(ObjectId id, Role role) {
        PersonStorageService personStorageService = getPersonStorageService(role);

        return personStorageService.findPerson(id);
    }

    public Person updatePerson(ObjectId id, Role role, PersonRequestDto personRequestDto) {
        PersonStorageService personStorageService = getPersonStorageService(role);
        Person oldPerson = personStorageService.findPerson(id);
        PersonFactory personFactory = PersonFactoryProvider.getFactory(personRequestDto.getRole());
        Person newPerson = personFactory.createPerson(personRequestDto);

        PersonUpdateService personUpdateService = getUpdateService(personRequestDto.getRole());
        oldPerson= personUpdateService.updatePersonService(oldPerson, newPerson);
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
        return switch (role) {
            case Role.PLAYER -> playerStorageService;
            case Role.REFEREE -> refereeStorageService;
            case Role.COACH -> coachStorageService;
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };

    }

    private PersonUpdateService getUpdateService(Role role) {
        return switch (role) {
            case Role.PLAYER -> playerUpdateService;
            case Role.REFEREE -> refereeUpdateService;
            case Role.COACH -> coachUpdateService;
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };

    }
}
