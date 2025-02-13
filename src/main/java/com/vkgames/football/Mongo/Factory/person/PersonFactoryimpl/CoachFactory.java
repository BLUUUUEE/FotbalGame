package com.vkgames.football.Mongo.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Coach;
import com.vkgames.football.Mongo.Factory.person.PersonFactory;
import org.springframework.stereotype.Component;

@Component
public class CoachFactory implements PersonFactory {

//    private static CoachFactory coachFactory;
//
//    private CoachFactory() {
//
//    }
//
//    public static CoachFactory getCoachFactory() {
//        if (coachFactory == null) {
//            return coachFactory = new CoachFactory();
//        }
//
//        return coachFactory;
//    }


    public Person createPerson(PersonRequestDto personRequestDto) {

        Coach coach = new Coach();
        coach.setName(personRequestDto.getName());
        coach.setAge(personRequestDto.getAge());
        coach.setTeam(personRequestDto.getTeam());
        coach.setRole(personRequestDto.getRole());

        return coach;
    }
}
