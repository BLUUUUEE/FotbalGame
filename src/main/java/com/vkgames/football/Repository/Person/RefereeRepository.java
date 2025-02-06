package com.vkgames.football.Repository.Person;

import com.vkgames.football.Entity.Person.PersonImpl.Referee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RefereeRepository extends MongoRepository<Referee, ObjectId> {
    Referee findByName(String name);
}
