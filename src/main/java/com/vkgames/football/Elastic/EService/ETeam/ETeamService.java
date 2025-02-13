package com.vkgames.football.Elastic.EService.ETeam;

import com.vkgames.football.Elastic.EEntity.ETeam.ETeam;
import com.vkgames.football.Mongo.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Mongo.Dto.TeamDto.TeamResponseDto;

public interface ETeamService {
    ETeam createETeam(TeamRequestDto teamRequestDto);

    ETeam getTeamById(String id);

    ETeam updateETeam(String id, TeamRequestDto newTeamDto);

    void deleteETeam(String id);

    ETeam getETeamByTeamName(String teamName);
}
