package com.vkgames.football.Elastic.ERepository.EStats;

import com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl.ETeamStats;
import com.vkgames.football.Elastic.EEntity.ETeam.ETeam;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ETeamStatsRepository extends ElasticsearchRepository<ETeamStats,String> {
    ETeamStats findByteamName(String name);
    void deleteByteamName(String name);
}
