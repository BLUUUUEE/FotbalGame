package com.vkgames.football.Service.Stats;

import com.vkgames.football.Entity.Match.Match;
import org.bson.types.ObjectId;

public interface StatsService {
    void updateStats(Match match);

}
