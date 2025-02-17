package com.vkgames.football.elastic.repository.stats;

import com.vkgames.football.elastic.entity.stats.statsImpl.EPlayerStats;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EPlayerStatsRepository extends ElasticsearchRepository<EPlayerStats,String> {



//    @Query("{\"size\": 1, \"sort\": [{ \"totalGoals\": { \"order\": \"desc\" } }], \"_source\": [\"id\", \"playerName\", \"totalGoals\", \"yellowCards\", \"redCards\", \"matchesPlayed\"]}")
//    EPlayerStats findPlayerWithMaxGoals();
}
