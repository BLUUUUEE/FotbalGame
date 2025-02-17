package com.vkgames.football.elastic.entity.stats.statsImpl;

import com.vkgames.football.elastic.entity.stats.EStats;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "team_stats")
public class ETeamStats implements EStats {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    private String teamName;
    private Integer trophies=0;
    private Integer matchesPlayed=0;
    private Integer matchesWon=0;
    private Integer matchedDraw=0;
    private Integer matchesLost=0;
}
