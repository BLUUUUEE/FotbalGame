package com.vkgames.football.mongo.repository.stats;

import com.vkgames.football.mongo.entity.stats.StatsImpl.PlayerStats;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PlayerStatsRepository extends MongoRepository<PlayerStats, String> {


}
