package com.vkgames.football.mongo.repository.person;

import com.vkgames.football.mongo.entity.person.PersonImpl.Referee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RefereeRepository extends MongoRepository<Referee, String> {
    Referee findByName(String name);
}
