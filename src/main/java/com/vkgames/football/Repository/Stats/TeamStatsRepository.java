package com.vkgames.football.Repository.Stats;

import com.vkgames.football.Entity.Stats.StatsImpl.TeamStats;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamStatsRepository extends MongoRepository<TeamStats, ObjectId> {

    TeamStats findByteamName(String name);
}
