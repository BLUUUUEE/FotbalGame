package com.vkgames.football.Entity.Match;

import com.vkgames.football.Dto.TeamDto.MatchTeamDto;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Match")
public class Match {
    @Id
    private ObjectId matchId;
    private MatchTeamDto matchTeamDto1;
    private MatchTeamDto matchTeamDto2;
    private String result;
    private String refereeName;

}
