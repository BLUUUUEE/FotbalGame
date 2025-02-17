package com.vkgames.football.mongo.entity.team;


import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

@Document(collection = "Team")  // MongoDB collection

public class Team {
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
