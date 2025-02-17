package com.vkgames.football.mongo.entity.stats.StatsImpl;

import com.vkgames.football.mongo.entity.stats.Stats;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "team_stats")  // MongoDB collection

public class TeamStats implements Stats {
    private String id;
    private String teamName;
    private Integer trophies=0;
    private Integer matchesPlayed=0;
    private Integer matchesWon=0;
    private Integer matchedDraw=0;
    private Integer matchesLost=0;
}
