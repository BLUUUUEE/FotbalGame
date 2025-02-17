package com.vkgames.football.elastic.service.team.teamServiceImpl;

import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.elastic.repository.ETeamRepository;
import com.vkgames.football.elastic.service.stats.statsServiceImpl.ETeamStatsService;
import com.vkgames.football.elastic.service.team.ETeamService;
import com.vkgames.football.elastic.service.team.teamUpdationService.ETeamUpdationService;
import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.mongo.entity.person.PersonImpl.Player;
import com.vkgames.football.transformer.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ETeamServiceImpl implements ETeamService {

    @Autowired
    private ETeamStatsService eTeamStatsService;
    @Autowired
    private ETeamRepository eTeamRepository;
    @Autowired
    private ETeamUpdationService eTeamUpdationService;

    @Override
    public ETeam createETeam(TeamRequestDto teamRequestDto) {
        ETeam eTeam = TeamDtoTransformer.teamDtoToETeam(teamRequestDto);
        eTeamStatsService.createETeamStats(teamRequestDto.getTeamName());

        eTeamRepository.save(eTeam);
        return eTeam;
    }

    @Override
    public ETeam getTeamById(String id) {
        Optional<ETeam> eTeam = eTeamRepository.findById(id);
        if (eTeam.isPresent()) {
            return eTeam.get();
        } else {
            return null;
        }
    }

    @Override
    public ETeam updateETeam(String id, TeamRequestDto newTeamDto) {
        return eTeamUpdationService.updateETeam(id, newTeamDto);
    }

    @Override
    public void deleteETeam(String id) {
        eTeamRepository.deleteById(id);
    }

    @Override
    public ETeam getETeamByTeamName(String teamName) {
        return eTeamRepository.findByteamName(teamName);
    }


}
