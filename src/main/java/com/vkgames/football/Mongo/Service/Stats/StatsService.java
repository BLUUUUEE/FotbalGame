package com.vkgames.football.Mongo.Service.Stats;

import com.vkgames.football.Mongo.Entity.Match.Match;

public interface StatsService {
    void updateStats(Match match);

}
