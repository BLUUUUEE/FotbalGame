package com.vkgames.football.Elastic.EService.ETeam.ETeamServiceImpl;

import com.vkgames.football.Elastic.EEntity.ETeam.ETeam;
import com.vkgames.football.Elastic.ERepository.ETeamRepository;
import com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl.ETeamStatsService;
import com.vkgames.football.Elastic.EService.ETeam.ETeamService;
import com.vkgames.football.Elastic.EService.ETeam.ETeamUpdationService.ETeamUpdationService;
import com.vkgames.football.Mongo.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Transformer.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
