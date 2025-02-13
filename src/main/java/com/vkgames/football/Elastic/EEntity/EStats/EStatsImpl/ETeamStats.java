package com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl;

import com.vkgames.football.Elastic.EEntity.EStats.EStats;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "team_stats")
public class ETeamStats implements EStats {
    private String id;
    private String teamName;
    private Integer trophies=0;
    private Integer matchesPlayed=0;
    private Integer matchesWon=0;
    private Integer matchedDraw=0;
    private Integer matchesLost=0;
}
