package com.vkgames.football.Repository;

import com.vkgames.football.Entity.Match.Match;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, ObjectId> {

}
