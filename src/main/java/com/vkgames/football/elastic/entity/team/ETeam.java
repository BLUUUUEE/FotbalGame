package com.vkgames.football.elastic.entity.team;

import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "team")
public class ETeam {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon=0;
    private long matchesLost=0;
    private long matchesDraw=0;
}
