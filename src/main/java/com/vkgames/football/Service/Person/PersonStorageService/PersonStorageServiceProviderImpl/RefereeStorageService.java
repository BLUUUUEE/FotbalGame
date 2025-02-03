package com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Person.PersonImpl.Referee;
import com.vkgames.football.Repository.RefereeRepository;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefereeStorageService implements PersonStorageService {

    @Autowired
    private RefereeRepository refereeRepository;
    @Override
    public void savePerson(Person person) {
        Referee referee = (Referee) person;
        refereeRepository.save(referee);

        System.out.println("Referee saved!!");

    }

    @Override
    public Person findPerson(ObjectId id) {
        Optional<Referee> referee = refereeRepository.findById(id);
        System.out.println(referee.get().getName());
        if(referee.isPresent()){
            return referee.get();
        }else {
            return null;
        }
    }

    @Override
    public void deletePerson(ObjectId id) {
        refereeRepository.deleteById(id);
    }


}
