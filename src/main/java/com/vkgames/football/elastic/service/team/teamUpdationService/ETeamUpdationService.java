package com.vkgames.football.elastic.service.team.teamUpdationService;

import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.elastic.repository.ETeamRepository;
import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.transformer.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ETeamUpdationService {
    @Autowired
    private ETeamRepository eTeamRepository;


    public ETeam updateETeam(String id, TeamRequestDto teamRequestDto) {
        ETeam newTeam = TeamDtoTransformer.teamDtoToETeam(teamRequestDto);
        Optional<ETeam> team = eTeamRepository.findById(id);
        ETeam oldTeam = null;
        if (team.isPresent()) oldTeam = team.get();

        oldTeam.setTeamName(newTeam.getTeamName() != null ? newTeam.getTeamName() : oldTeam.getTeamName());
        oldTeam.setTeamPlayers(newTeam.getTeamPlayers());
        oldTeam.setFormation(newTeam.getFormation() != null ? newTeam.getFormation() : oldTeam.getFormation());
        oldTeam.setCoachName(newTeam.getCoachName() != null ? newTeam.getCoachName() : oldTeam.getCoachName());
        oldTeam.setMatchesWon(Math.max(newTeam.getMatchesWon(), oldTeam.getMatchesWon()));
        oldTeam.setMatchesDraw(Math.max(newTeam.getMatchesDraw(), oldTeam.getMatchesDraw()));
        oldTeam.setMatchesLost(Math.max(newTeam.getMatchesLost(), oldTeam.getMatchesLost()));

        eTeamRepository.save(oldTeam);
//        teamElasticRepository.save(oldTeam);
        return oldTeam;
    }
}
