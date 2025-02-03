package com.vkgames.football.Service.Team.TeamServiceImpl;

import com.vkgames.football.Dto.TeamRequestDto;
import com.vkgames.football.Entity.Team.Team;
import com.vkgames.football.Repository.TeamRepository;
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
    @Override
    public Team createTeam(TeamRequestDto teamRequestDto) {
            Team team = TeamDtoTransformer.teamDtoToTeamTransformer(teamRequestDto);
            teamRepository.save(team);
            return team;
    }

    @Override
    public Team getTeamById(ObjectId id) {
        Optional<Team>team = teamRepository.findById(id);
        return team.orElse(null);
    }

    @Override
    public Team updateTeam(ObjectId id, TeamRequestDto newTeamDto) {
        return teamUpdationService.updateTeam(id,newTeamDto);
    }

    @Override
    public void deleteTeam(ObjectId id) {
        teamRepository.deleteById(id);
    }
}
