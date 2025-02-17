package com.vkgames.football.elastic.entity.stats.statsImpl;

import com.vkgames.football.elastic.entity.stats.EStats;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "player_stats")
public class EPlayerStats implements EStats {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    private String playerName;
    private Integer totalGoals=0;
    private Integer yellowCards=0;
    private Integer redCards=0;
    private Integer matchesPlayed=0;
}
