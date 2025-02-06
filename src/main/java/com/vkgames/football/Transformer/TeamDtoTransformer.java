package com.vkgames.football.Transformer;

import com.vkgames.football.Dto.PersonDto.TeamPlayerDto;
import com.vkgames.football.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Dto.TeamDto.TeamResponseDto;
import com.vkgames.football.Entity.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDtoTransformer {

    public static Team teamDtoToTeam(TeamRequestDto teamRequestDto) {
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

    public static TeamResponseDto teamToTeamDto(Team team) {
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        teamResponseDto.setId(team.getId());
        teamResponseDto.setTeamName(team.getTeamName());
        teamResponseDto.setCoachName(team.getCoachName());
        List<TeamPlayerDto> teamPlayers = new ArrayList<>();
        for (TeamPlayerDto p : team.getTeamPlayers()) {
            teamPlayers.add(p);
        }
        if (teamPlayers.size() == 0) {
            System.out.println("no members in the team");
        }
        teamResponseDto.setTeamPlayers(teamPlayers);
        teamResponseDto.setFormation(team.getFormation());
        teamResponseDto.setMatchesWon(team.getMatchesWon());
        teamResponseDto.setMatchesDraw(team.getMatchesDraw());
        teamResponseDto.setMatchesLost(team.getMatchesLost());
        return teamResponseDto;

    }
}
