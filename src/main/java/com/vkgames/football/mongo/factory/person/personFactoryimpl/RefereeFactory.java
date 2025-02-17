package com.vkgames.football.mongo.factory.person.personFactoryimpl;

import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Referee;
import com.vkgames.football.mongo.factory.person.PersonFactory;
import org.springframework.stereotype.Component;

@Component
public class RefereeFactory implements PersonFactory {


//    private static RefereeFactory refereeFactory;

//    private RefereeFactory() {
//    }
//
//    ;
//
//    public static RefereeFactory getRefereeFactory() {
//        if (refereeFactory == null) {
//            refereeFactory = new RefereeFactory();
//        }
//        return refereeFactory;
//    }


    public Person createPerson(PersonRequestDto personRequestDto) {
        Referee referee = new Referee();
        referee.setId(IdGenerator.generateIdForCoach(personRequestDto.getName()));
        referee.setName(personRequestDto.getName());
        referee.setAge(personRequestDto.getAge());
        referee.setRole(personRequestDto.getRole());

        return referee;
    }
}
