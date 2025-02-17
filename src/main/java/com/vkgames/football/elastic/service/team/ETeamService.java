package com.vkgames.football.elastic.service.team;

import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;

import java.util.List;

public interface ETeamService {
    ETeam createETeam(TeamRequestDto teamRequestDto);

    ETeam getTeamById(String id);

    ETeam updateETeam(String id, TeamRequestDto newTeamDto);

    void deleteETeam(String id);

    ETeam getETeamByTeamName(String teamName);


}
