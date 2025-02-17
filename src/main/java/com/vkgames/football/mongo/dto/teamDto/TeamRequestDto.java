package com.vkgames.football.mongo.dto.teamDto;

import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequestDto {

    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon=0;
    private long matchesLost=0;
    private long matchesDraw=0;
}
