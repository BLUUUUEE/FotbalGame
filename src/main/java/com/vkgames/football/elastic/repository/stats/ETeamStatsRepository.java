package com.vkgames.football.elastic.repository.stats;

import com.vkgames.football.elastic.entity.stats.statsImpl.ETeamStats;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ETeamStatsRepository extends ElasticsearchRepository<ETeamStats,String> {
    ETeamStats findByteamName(String name);
    void deleteByteamName(String name);
}
