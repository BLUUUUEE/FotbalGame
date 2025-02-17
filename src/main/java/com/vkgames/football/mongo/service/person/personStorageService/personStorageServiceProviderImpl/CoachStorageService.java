package com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Coach;
import com.vkgames.football.mongo.repository.person.CoachRepository;
import com.vkgames.football.role.Role;
import com.vkgames.football.mongo.service.person.personStorageService.PersonStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachStorageService implements PersonStorageService {

    @Autowired
    private CoachRepository coachRepository;


    @Override
    public void savePerson(Person person) {
        Coach coach = (Coach) person;
        coachRepository.save(coach);
//        coachElasticRepository.save(coach);
        System.out.println("Coach saved!!");
    }

    @Override
    public Person findPerson(String id) {
        Optional<Coach> coach = coachRepository.findById(id);
        System.out.println(coach.get().getName());
        if (coach.isPresent()) {
            return coach.get();
        } else {
            return null;
        }
    }


    @Override
    public void deletePerson(String id) {

        coachRepository.deleteById(id);
//        coachElasticRepository.deleteById(id);
    }

    @Override
    public Person findPersonByNameAndRole(String name) {

        return (Person) coachRepository.findByName(name);
    }

    @Override
    public List<Person> getAll(Role role) {
        Iterable<Coach> coachList = coachRepository .findAll();
        List<Person> personList = null;
        for (Coach c : coachList) {
            personList.add((Person) c);
        }
        return personList;

    }


}
