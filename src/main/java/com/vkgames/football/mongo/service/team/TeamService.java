package com.vkgames.football.mongo.service.team;

import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.mongo.dto.teamDto.TeamResponseDto;
import com.vkgames.football.mongo.entity.team.Team;

public interface TeamService {

    Team createTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto getTeamById(String id);

    Team updateTeam(String id, TeamRequestDto newTeamDto);

    void deleteTeam(String id);

    Team getTeamByTeamName(String teamName);
}
