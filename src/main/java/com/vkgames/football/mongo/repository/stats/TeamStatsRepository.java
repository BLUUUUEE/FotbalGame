package com.vkgames.football.mongo.repository.stats;

import com.vkgames.football.mongo.entity.stats.StatsImpl.TeamStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamStatsRepository extends MongoRepository<TeamStats, String> {

    TeamStats findByteamName(String name);
    void deleteByteamName(String name);
}
