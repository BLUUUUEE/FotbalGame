package com.vkgames.football.Entity.Stats.StatsImpl;

import com.vkgames.football.Entity.Stats.Stats;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "player_stats")
public class PlayerStats implements Stats {
    private ObjectId id;
    private String playerName;
    private Integer totalGoals=0;
    private Integer yellowCards=0;
    private Integer redCards=0;
    private Integer matchesPlayed=0;
}
