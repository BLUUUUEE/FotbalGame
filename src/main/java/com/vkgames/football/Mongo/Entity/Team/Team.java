package com.vkgames.football.Mongo.Entity.Team;


import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

@Document(collection = "Team")  // MongoDB collection

public class Team {
    @Id
    private ObjectId id;
    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon=0;
    private long matchesLost=0;
    private long matchesDraw=0;
}
