package com.vkgames.football.Service.Team.TeamServiceImpl;

import com.vkgames.football.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Dto.TeamDto.TeamResponseDto;
import com.vkgames.football.Entity.Team.Team;
import com.vkgames.football.Repository.TeamRepository;
import com.vkgames.football.Service.Person.PersonService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.CoachStorageService;
import com.vkgames.football.Service.Person.PersonStorageService.PersonStorageServiceProviderImpl.PlayerStorageService;
import com.vkgames.football.Service.Stats.StatsServiceImpl.TeamStatsService;
import com.vkgames.football.Service.Team.TeamService;
import com.vkgames.football.Service.Team.TeamUpdationService.TeamUpdationService;
import com.vkgames.football.Transformer.TeamDtoTransformer;
import org.bson.types.ObjectId;
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
        teamStatsService.createTeamStats(teamRequestDto.getTeamName());

        teamRepository.save(team);
        return team;
    }

    @Override
    public TeamResponseDto getTeamById(ObjectId id) {
        Optional<Team> team = teamRepository.findById(id);
        TeamResponseDto teamResponseDto = TeamDtoTransformer.teamToTeamDto(team.get());
        return teamResponseDto;
    }

    @Override
    public Team updateTeam(ObjectId id, TeamRequestDto newTeamDto) {
        return teamUpdationService.updateTeam(id, newTeamDto);
    }

    @Override
    public void deleteTeam(ObjectId id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team getTeamByTeamName(String teamName) {
        return teamRepository.findByteamName(teamName);

    }
}
