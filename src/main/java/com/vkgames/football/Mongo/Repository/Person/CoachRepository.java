package com.vkgames.football.Mongo.Repository.Person;

import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Coach;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends MongoRepository<Coach, ObjectId> {

    Coach findByName(String name);
}
