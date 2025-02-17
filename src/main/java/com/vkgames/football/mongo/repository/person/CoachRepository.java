package com.vkgames.football.mongo.repository.person;

import com.vkgames.football.mongo.entity.person.PersonImpl.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends MongoRepository<Coach, String> {

    Coach findByName(String name);
}
