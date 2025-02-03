package com.vkgames.football.Service.Team;

import com.vkgames.football.Dto.TeamRequestDto;
import com.vkgames.football.Entity.Team.Team;
import org.bson.types.ObjectId;

public interface TeamService {

    Team createTeam(TeamRequestDto teamRequestDto);

    Team getTeamById(ObjectId id);

    Team updateTeam(ObjectId id,TeamRequestDto newTeamDto);

    void deleteTeam(ObjectId id);
}
