package com.vkgames.football.mongo.service.person.personStorageService.personStorageServiceProviderImpl;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Referee;
import com.vkgames.football.mongo.repository.person.RefereeRepository;
import com.vkgames.football.mongo.service.person.personStorageService.PersonStorageService;
import com.vkgames.football.role.Role;
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
    public Person findPerson(String id) {
        Optional<Referee> referee = refereeRepository.findById(id);
        System.out.println(referee.get().getName());
        if (referee.isPresent()) {
            return referee.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(String id) {
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
