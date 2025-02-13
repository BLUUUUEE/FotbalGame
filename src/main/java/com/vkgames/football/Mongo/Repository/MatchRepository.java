package com.vkgames.football.Mongo.Repository;

import com.vkgames.football.Mongo.Entity.Match.Match;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, ObjectId> {

}
