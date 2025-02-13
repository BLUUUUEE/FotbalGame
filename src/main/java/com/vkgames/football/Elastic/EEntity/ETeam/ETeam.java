package com.vkgames.football.Elastic.EEntity.ETeam;

import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "team")
public class ETeam {

    @Id
    private String id;
    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon=0;
    private long matchesLost=0;
    private long matchesDraw=0;
}
