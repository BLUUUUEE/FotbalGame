package com.vkgames.football.mongo.service.team.teamServiceImpl;

import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.mongo.dto.teamDto.TeamResponseDto;
import com.vkgames.football.mongo.entity.stats.StatsImpl.TeamStats;
import com.vkgames.football.mongo.entity.team.Team;
import com.vkgames.football.mongo.repository.TeamRepository;
import com.vkgames.football.mongo.service.stats.statsServiceImpl.TeamStatsService;
import com.vkgames.football.mongo.service.team.TeamService;
import com.vkgames.football.mongo.service.team.teamUpdationService.TeamUpdationService;
import com.vkgames.football.transformer.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamUpdationService teamUpdationService;
    @Autowired
    private TeamStatsService teamStatsService;

    @Override
    public Team createTeam(TeamRequestDto teamRequestDto) {
        Team team = TeamDtoTransformer.teamDtoToTeam(teamRequestDto);
        System.out.println(team);
        TeamStats teamStats=teamStatsService.createTeamStats(teamRequestDto.getTeamName());

        teamRepository.save(team);
        return team;
    }

    @Override
    public TeamResponseDto getTeamById(String id) {
        Optional<Team> team = teamRepository.findById(id);
        TeamResponseDto teamResponseDto = TeamDtoTransformer.teamToTeamDto(team.get());
        return teamResponseDto;
    }

    @Override
    public Team updateTeam(String id, TeamRequestDto newTeamDto) {
        return teamUpdationService.updateTeam(id, newTeamDto);
    }

    @Override
    public void deleteTeam(String id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            teamStatsService.deleteStatsByName(team.get().getTeamName());

        }
        teamRepository.deleteById(id);
//
    }

    @Override
    public Team getTeamByTeamName(String teamName) {
        return teamRepository.findByteamName(teamName);

    }
}
