package com.vkgames.football.Mongo.Repository;

import com.vkgames.football.Mongo.Entity.Team.Team;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, ObjectId> {
    Team findByteamName(String teamName);
}
