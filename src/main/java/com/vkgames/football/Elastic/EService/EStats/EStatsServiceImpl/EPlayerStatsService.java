package com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl;

import com.vkgames.football.Elastic.EEntity.EStats.EStatsImpl.EPlayerStats;
import com.vkgames.football.Elastic.ERepository.EStats.EPlayerStatsRepository;
import com.vkgames.football.Elastic.EService.EStats.EStatsService;
import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EPlayerStatsService implements EStatsService {
    @Autowired
    private EPlayerStatsRepository ePlayerStatsRepository;

    @Override
    public void updateEStats(Match match) {
        List<TeamPlayerDto> team1GoalScorers = match.getMatchTeamDto1().getGoalScorers();
        List<TeamPlayerDto> team2GoalScorers = match.getMatchTeamDto2().getGoalScorers();


        updateEPlayerStats(team1GoalScorers);
        updateEPlayerStats(team2GoalScorers);

    }

    public String createEPlayerStats(String playerName) {

        EPlayerStats ePlayerStats = new EPlayerStats();
        ePlayerStats.setPlayerName(playerName);

        EPlayerStats savedEPlayerStats = ePlayerStatsRepository.save(ePlayerStats);
        ePlayerStatsRepository.save(ePlayerStats);

        return savedEPlayerStats.getId();

    }

    public EPlayerStats getEPlayerStats(String id) {
        Optional<EPlayerStats> ePlayerStats = ePlayerStatsRepository.findById(id);
        return ePlayerStats.orElse(null);
    }

    public void deleteEPlayerStats(String id) {
        ePlayerStatsRepository.deleteById(id);

    }

    private void updateEPlayerStats(List<TeamPlayerDto> goalScorers) {
        if (goalScorers == null || goalScorers.isEmpty()) {
            return;
        }
        Map<String, Integer> goalScorersMap = new HashMap<>();
        for (TeamPlayerDto t : goalScorers) {
            goalScorersMap.put(t.getStatsId().toString(), goalScorersMap.getOrDefault(t.getStatsId(), 0) + 1);
        }

        for (String i : goalScorersMap.keySet()) {
            EPlayerStats ePlayerStats = getEPlayerStats(i);

            if (ePlayerStats != null) {
                ePlayerStats.setTotalGoals(ePlayerStats.getTotalGoals() + goalScorersMap.getOrDefault(i, 0));
                ePlayerStats.setMatchesPlayed(ePlayerStats.getMatchesPlayed() + 1);
                ePlayerStatsRepository.save(ePlayerStats);
            }
        }

    }
}
