package com.vkgames.football.Repository;

import com.vkgames.football.Entity.Person.PersonImpl.Coach;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends MongoRepository<Coach, ObjectId> {
}
