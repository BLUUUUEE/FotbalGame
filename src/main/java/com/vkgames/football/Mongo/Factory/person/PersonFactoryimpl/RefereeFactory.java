package com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Referee;
import com.vkgames.football.Mongo.Factory.person.PersonFactory;
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
        referee.setName(personRequestDto.getName());
        referee.setAge(personRequestDto.getAge());
        referee.setRole(personRequestDto.getRole());

        return referee;
    }
}
