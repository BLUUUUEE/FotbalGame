package com.vkgames.football.elastic.service.stats.statsServiceImpl;

import com.vkgames.football.elastic.entity.stats.statsImpl.EPlayerStats;
import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.elastic.repository.ETeamRepository;
import com.vkgames.football.elastic.repository.stats.EPlayerStatsRepository;
import com.vkgames.football.elastic.service.stats.EStatsService;
import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import com.vkgames.football.mongo.entity.match.Match;
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
    @Autowired
    private ETeamRepository eTeamRepository;

    @Override
    public void updateEStats(Match match) {
        List<TeamPlayerDto> team1GoalScorers = match.getMatchTeamDto1().getGoalScorers();
        List<TeamPlayerDto> team2GoalScorers = match.getMatchTeamDto2().getGoalScorers();


       updateEPlayerStats(team1GoalScorers);
       updateEPlayerStats(team2GoalScorers);

        updateMatchesPlayed(match.getMatchTeamDto1().getName());
        updateMatchesPlayed(match.getMatchTeamDto2().getName());

    }

    private void updateMatchesPlayed(String teamName){
        ETeam eTeam = eTeamRepository.findByteamName(teamName);
        List<TeamPlayerDto>teamPlayers = eTeam.getTeamPlayers();
        for(TeamPlayerDto t:teamPlayers){
            Optional<EPlayerStats> ePlayerStats = ePlayerStatsRepository.findById(t.getStatsId());
            ePlayerStats.get().setMatchesPlayed(ePlayerStats.get().getMatchesPlayed()+1);
            ePlayerStatsRepository.save(ePlayerStats.get());
        }

    }

    public String createEPlayerStats(String playerName,long age,String position) {

        EPlayerStats ePlayerStats = new EPlayerStats();
        ePlayerStats.setPlayerName(playerName);
        ePlayerStats.setId(IdGenerator.generateIdForPlayerStats(playerName,age,position));

        EPlayerStats savedEPlayerStats = ePlayerStatsRepository.save(ePlayerStats);


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
            goalScorersMap.put(t.getStatsId(), goalScorersMap.getOrDefault(t.getStatsId(), 0) + 1);
        }

        for (String i : goalScorersMap.keySet()) {
            EPlayerStats ePlayerStats = getEPlayerStats(i);

            if (ePlayerStats != null) {
                ePlayerStats.setTotalGoals(ePlayerStats.getTotalGoals() + goalScorersMap.getOrDefault(i, 0));

                ePlayerStatsRepository.save(ePlayerStats);
            }
        }

    }
}
