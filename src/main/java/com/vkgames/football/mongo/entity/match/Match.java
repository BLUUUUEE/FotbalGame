package com.vkgames.football.mongo.entity.match;

import com.vkgames.football.mongo.dto.teamDto.MatchTeamDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mongodb.core.mapping.Document;


@Data

@Document(collection = "Match")
public class Match {
    @Id
    @Field(type = FieldType.Keyword)
    private String matchId;

    private MatchTeamDto matchTeamDto1;
    private MatchTeamDto matchTeamDto2;
    private String result;
    private String refereeName;

}
