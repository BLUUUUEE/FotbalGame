package com.vkgames.football.Mongo.Entity.Stats.StatsImpl;

import com.vkgames.football.Mongo.Entity.Stats.Stats;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "team_stats")  // MongoDB collection

public class TeamStats implements Stats {
    private ObjectId id;
    private String teamName;
    private Integer trophies=0;
    private Integer matchesPlayed=0;
    private Integer matchesWon=0;
    private Integer matchedDraw=0;
    private Integer matchesLost=0;
}
