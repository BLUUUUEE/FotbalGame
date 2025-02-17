package com.vkgames.football.mongo.repository;

import com.vkgames.football.mongo.entity.team.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
    Team findByteamName(String teamName);
}
