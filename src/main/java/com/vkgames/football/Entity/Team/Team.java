package com.vkgames.football.Entity.Team;


import com.vkgames.football.Dto.PersonDto.TeamPlayerDto;
import com.vkgames.football.Entity.Person.PersonImpl.Coach;
import com.vkgames.football.Entity.Person.PersonImpl.Player;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Team")
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
