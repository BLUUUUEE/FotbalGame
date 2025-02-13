package com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl;

import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Referee;
import com.vkgames.football.Mongo.Repository.Person.RefereeRepository;
import com.vkgames.football.Role.Role;
import com.vkgames.football.Mongo.Service.Person.PersonStorageService.PersonStorageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeStorageService implements PersonStorageService {

    @Autowired
    private RefereeRepository refereeRepository;

    @Override
    public void savePerson(Person person) {
        Referee referee = (Referee) person;
        refereeRepository.save(referee);
//        refereeElasticRepository.save(referee);

        System.out.println("Referee saved!!");

    }

    @Override
    public Person findPerson(ObjectId id) {
        Optional<Referee> referee = refereeRepository.findById(id);
        System.out.println(referee.get().getName());
        if (referee.isPresent()) {
            return referee.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(ObjectId id) {
        refereeRepository.deleteById(id);
//        refereeElasticRepository.deleteById(id);
    }

    @Override
    public Person findPersonByNameAndRole(String name) {

        return (Person) refereeRepository.findByName(name);
    }

    @Override
    public List<Person> getAll(Role role) {
        Iterable<Referee> refereeList = refereeRepository.findAll();
        List<Person> personList = null;
        for (Referee R : refereeList) {
            personList.add((Person) R);
        }
        return personList;
    }


}
