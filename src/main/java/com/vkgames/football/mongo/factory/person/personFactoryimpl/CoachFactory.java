package com.vkgames.football.mongo.factory.person.personFactoryimpl;

import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.mongo.entity.person.PersonImpl.Coach;
import com.vkgames.football.mongo.factory.person.PersonFactory;
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
        coach.setId(IdGenerator.generateIdForCoach(personRequestDto.getName()));
        coach.setName(personRequestDto.getName());
        coach.setAge(personRequestDto.getAge());
        coach.setTeam(personRequestDto.getTeam());
        coach.setRole(personRequestDto.getRole());

        return coach;
    }
}
