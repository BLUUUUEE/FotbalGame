package com.vkgames.football.mongo.service.stats;

import com.vkgames.football.mongo.entity.match.Match;

public interface StatsService {
    void updateStats(Match match);

}
