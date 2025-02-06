package com.vkgames.football.Repository.Stats;

import com.vkgames.football.Entity.Stats.StatsImpl.PlayerStats;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface PlayerStatsRepository extends MongoRepository<PlayerStats, ObjectId> {


}
