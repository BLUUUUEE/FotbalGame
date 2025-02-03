package com.vkgames.football.Transformer;

import com.vkgames.football.Dto.TeamRequestDto;
import com.vkgames.football.Entity.Team.Team;

public class TeamDtoTransformer {
    public static Team teamDtoToTeamTransformer(TeamRequestDto teamRequestDto){
            Team team = new Team();
            team.setTeamName(teamRequestDto.getTeamName());
            team.setCoachName(teamRequestDto.getCoachName());
            team.setTeamPlayers(teamRequestDto.getTeamPlayers());
            team.setFormation(teamRequestDto.getFormation());
            team.setMatchesDraw(teamRequestDto.getMatchesDraw());
            team.setMatchesWon(teamRequestDto.getMatchesWon());
            team.setMatchesLost(teamRequestDto.getMatchesLost());

        return team;
    }

    public static TeamRequestDto teamToTeamDtoTransformer(Team team){
        TeamRequestDto teamRequestDto = new TeamRequestDto();
        teamRequestDto.setId(team.getId());
        teamRequestDto.setTeamName(team.getTeamName());
        teamRequestDto.setCoachName(team.getCoachName());
        teamRequestDto.setTeamPlayers(team.getTeamPlayers());
        teamRequestDto.setFormation(team.getFormation());
        teamRequestDto.setMatchesDraw(team.getMatchesDraw());
        teamRequestDto.setMatchesWon(team.getMatchesWon());
        teamRequestDto.setMatchesLost(team.getMatchesLost());

        return teamRequestDto;

    }
}
