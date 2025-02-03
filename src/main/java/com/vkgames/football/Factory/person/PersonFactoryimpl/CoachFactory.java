package com.vkgames.football.Factory.person.PersonFactoryimpl;

import com.vkgames.football.Dto.PersonRequestDto;
import com.vkgames.football.Entity.Person.PersonImpl.Coach;
import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Factory.person.PersonFactory;

public class CoachFactory implements PersonFactory {

    private static CoachFactory coachFactory;

    private CoachFactory(){

    }

    public static CoachFactory getCoachFactory(){
        if(coachFactory==null){
           return coachFactory = new CoachFactory();
        }

        return coachFactory;
    }




    public Person createPerson(PersonRequestDto personRequestDto) {

        Coach coach = new Coach();
        coach.setName(personRequestDto.getName());
        coach.setAge(personRequestDto.getAge());
        coach.setTeam(personRequestDto.getTeam());
        coach.setRole(personRequestDto.getRole());

        return coach;
    }
}
