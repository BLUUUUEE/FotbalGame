package com.vkgames.football.mongo.service.team.teamUpdationService;

import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.mongo.entity.team.Team;
import com.vkgames.football.mongo.repository.TeamRepository;
import com.vkgames.football.transformer.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamUpdationService {

    @Autowired
    private TeamRepository teamRepository;


    public Team updateTeam(String id, TeamRequestDto teamRequestDto) {
        Team newTeam = TeamDtoTransformer.teamDtoToTeam(teamRequestDto);
        Optional<Team> team = teamRepository.findById(id);
        Team oldTeam = null;
        if (team.isPresent()) oldTeam = team.get();

        oldTeam.setTeamName(newTeam.getTeamName() != null ? newTeam.getTeamName() : oldTeam.getTeamName());
        oldTeam.setTeamPlayers(newTeam.getTeamPlayers());
        oldTeam.setFormation(newTeam.getFormation() != null ? newTeam.getFormation() : oldTeam.getFormation());
        oldTeam.setCoachName(newTeam.getCoachName() != null ? newTeam.getCoachName() : oldTeam.getCoachName());
        oldTeam.setMatchesWon(Math.max(newTeam.getMatchesWon(), oldTeam.getMatchesWon()));
        oldTeam.setMatchesDraw(Math.max(newTeam.getMatchesDraw(), oldTeam.getMatchesDraw()));
        oldTeam.setMatchesLost(Math.max(newTeam.getMatchesLost(), oldTeam.getMatchesLost()));

        teamRepository.save(oldTeam);

        return oldTeam;
    }

}
