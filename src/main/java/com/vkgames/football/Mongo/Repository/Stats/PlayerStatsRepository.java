package com.vkgames.football.Mongo.Repository.Stats;

import com.vkgames.football.Mongo.Entity.Stats.StatsImpl.PlayerStats;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PlayerStatsRepository extends MongoRepository<PlayerStats, ObjectId> {


}
