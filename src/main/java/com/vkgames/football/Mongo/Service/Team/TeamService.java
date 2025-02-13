package com.vkgames.football.Mongo.Service.Team;

import com.vkgames.football.Mongo.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Mongo.Dto.TeamDto.TeamResponseDto;
import com.vkgames.football.Mongo.Entity.Team.Team;
import org.bson.types.ObjectId;

public interface TeamService {

    Team createTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto getTeamById(ObjectId id);

    Team updateTeam(ObjectId id, TeamRequestDto newTeamDto);

    void deleteTeam(ObjectId id);

    Team getTeamByTeamName(String teamName);
}
