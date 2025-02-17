package com.vkgames.football.mongo.dto.teamDto;

import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private String id;
    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon;
    private long matchesLost;
    private long matchesDraw;
}
