package com.vkgames.football.Repository;

import com.vkgames.football.Entity.Person.PersonImpl.Referee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RefereeRepository extends MongoRepository<Referee, ObjectId> {
}
