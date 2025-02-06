package com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Coach;
import com.vkgames.football.Repository.Person.CoachRepository;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageService;
import org.bson.types.ObjectId;
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
        System.out.println("Coach saved!!");
    }

    @Override
    public Person findPerson(ObjectId id) {
        Optional<Coach> coach = coachRepository.findById(id);
        System.out.println(coach.get().getName());
        if (coach.isPresent()) {
            return coach.get();
        } else {
            return null;
        }
    }


    @Override
    public void deletePerson(ObjectId id) {
        coachRepository.deleteById(id);
    }

    @Override
    public Person findPersonByNameAndRole(String name) {
        return (Person) coachRepository.findByName(name);
    }

    @Override
    public List<Person> getAll(Role role) {
        List<Coach> coachList = coachRepository.findAll();
        List<Person> personList = null;
        for (Coach c : coachList) {
            personList.add((Person) c);
        }
        return personList;

    }


}
