package com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl;

import com.vkgames.football.Elastic.EEntity.EStats.EStats;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "player_stats")
public class EPlayerStats implements EStats {
    private String id;
    private String playerName;
    private Integer totalGoals=0;
    private Integer yellowCards=0;
    private Integer redCards=0;
    private Integer matchesPlayed=0;
}
