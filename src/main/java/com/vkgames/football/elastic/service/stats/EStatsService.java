package com.vkgames.football.elastic.service.stats;

import com.vkgames.football.mongo.entity.match.Match;

public interface EStatsService {
    void updateEStats(Match Match);
}
