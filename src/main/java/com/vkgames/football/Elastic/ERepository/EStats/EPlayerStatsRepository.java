package com.vkgames.football.Elastic.ERepository.EStats;

import com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl.EPlayerStats;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EPlayerStatsRepository extends ElasticsearchRepository<EPlayerStats,String> {
}
