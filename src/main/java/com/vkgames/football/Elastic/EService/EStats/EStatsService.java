package com.vkgames.football.Elastic.EService.EStats;

import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Mongo.Entity.Match.Match;

public interface EStatsService {
    void updateEStats(Match Match);
}
