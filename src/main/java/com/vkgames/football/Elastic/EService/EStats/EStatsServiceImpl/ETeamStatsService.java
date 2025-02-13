package com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl;

import com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl.ETeamStats;
import com.vkgames.football.Elastic.ERepository.EStats.ETeamStatsRepository;
import com.vkgames.football.Elastic.EService.EStats.EStatsService;
import com.vkgames.football.Mongo.Dto.TeamDto.MatchTeamDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ETeamStatsService implements EStatsService {


    @Autowired
    private ETeamStatsRepository eTeamStatsRepository;

    @Override
    public void updateEStats(Match match) {
        MatchTeamDto team1 = match.getMatchTeamDto1();
        MatchTeamDto team2 = match.getMatchTeamDto2();


        String result = match.getResult();

        updateTeamStats(team1, result);
        updateTeamStats(team2, result);

    }


    public void createETeamStats(String name) {
        ETeamStats eTeamStats = new ETeamStats();
        eTeamStats.setTeamName(name);
        eTeamStatsRepository.save(eTeamStats);
    }

    public ETeamStats getEStatsByTeamName(String name) {
        return eTeamStatsRepository.findByteamName(name);
    }

    public void deleteEStatsByName(String name) {
        eTeamStatsRepository.deleteByteamName(name);
    }

    private void updateTeamStats(MatchTeamDto team, String result) {
        ETeamStats eTeamStats = eTeamStatsRepository.findByteamName(team.getName());
        if (result.equals("DRAW")) {
            eTeamStats.setMatchedDraw(eTeamStats.getMatchedDraw() + 1);
        } else {
            if (result.equals(team.getName())) {
                eTeamStats.setMatchesWon(eTeamStats.getMatchesWon() + 1);
            } else {
                eTeamStats.setMatchesLost(eTeamStats.getMatchesLost() + 1);
            }
        }
        eTeamStatsRepository.save(eTeamStats);

    }
}
