package com.vkgames.football.mongo.repository;

import com.vkgames.football.mongo.entity.match.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {

}
