package com.vkgames.football.Repository;

import com.vkgames.football.Entity.Team.Team;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, ObjectId> {
    Team findByteamName(String teamName);
}
