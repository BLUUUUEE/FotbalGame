package com.vkgames.football.elastic.entity.match;


import com.vkgames.football.mongo.dto.teamDto.MatchTeamDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "match")
public class EMatch {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    private MatchTeamDto matchTeamDto1;
    private MatchTeamDto matchTeamDto2;
    private String teams;
    private String matchScore;
    private Integer fouls;
    private String possession;
    private Integer corners;
    private Integer shots;
    private Integer substitutions;
    private Integer redCards;
    private Integer yellowCards;
    private Integer totalGoals;
    private String refereeName;
    private String result;

}
