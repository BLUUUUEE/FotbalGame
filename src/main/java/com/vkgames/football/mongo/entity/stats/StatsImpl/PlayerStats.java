package com.vkgames.football.mongo.entity.stats.StatsImpl;

import com.vkgames.football.mongo.entity.stats.Stats;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "player_stats")  // MongoDB collection

public class PlayerStats implements Stats {
    private String id;
    private String playerName;
    private Integer totalGoals=0;
    private Integer yellowCards=0;
    private Integer redCards=0;
    private Integer matchesPlayed=0;
}
