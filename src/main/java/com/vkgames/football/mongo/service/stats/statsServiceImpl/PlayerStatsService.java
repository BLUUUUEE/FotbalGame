package com.vkgames.football.mongo.service.stats.statsServiceImpl;

import com.vkgames.football.elastic.entity.stats.statsImpl.EPlayerStats;
import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.elastic.service.team.ETeamService;
import com.vkgames.football.mongo.entity.team.Team;
import com.vkgames.football.mongo.repository.TeamRepository;
import com.vkgames.football.mongo.service.team.TeamService;
import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.entity.stats.StatsImpl.PlayerStats;
import com.vkgames.football.mongo.repository.stats.PlayerStatsRepository;
import com.vkgames.football.mongo.service.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerStatsService implements StatsService {

    @Autowired
    private PlayerStatsRepository playerStatsRepository;
    @Autowired
    private ETeamService eTeamService;


    @Override
    public void updateStats(Match match) {

        List<TeamPlayerDto> team1GoalScorers = match.getMatchTeamDto1().getGoalScorers();
        List<TeamPlayerDto> team2GoalScorers = match.getMatchTeamDto2().getGoalScorers();


        updatePlayerStats(team1GoalScorers);
        updatePlayerStats(team2GoalScorers);
        updateMatchesPlayed(match.getMatchTeamDto1().getName());
        updateMatchesPlayed(match.getMatchTeamDto2().getName());

    }

    private void updateMatchesPlayed(String teamName){
        ETeam eTeam = eTeamService.getETeamByTeamName(teamName);
       if(eTeam!=null) {
            List<TeamPlayerDto> teamPlayers = eTeam.getTeamPlayers();
            for (TeamPlayerDto t : teamPlayers) {
                Optional<PlayerStats> playerStats = playerStatsRepository.findById(t.getStatsId());
                playerStats.get().setMatchesPlayed(playerStats.get().getMatchesPlayed() + 1);
                playerStatsRepository.save(playerStats.get());
            }
        }else{
           System.out.println("no team present with this name");

       }
    }
    public String createPlayerStats(String playerName,long age,String position) {

        PlayerStats playerStats = new PlayerStats();
        playerStats.setPlayerName(playerName);
        playerStats.setId(IdGenerator.generateIdForPlayerStats(playerName,age,position));
        PlayerStats savedPlayerStats = playerStatsRepository.save(playerStats);
        playerStatsRepository.save(playerStats);

        return savedPlayerStats.getId();

    }

    public PlayerStats getPlayerStats(String id) {
        Optional<PlayerStats> playerStats = playerStatsRepository.findById(id);
        return playerStats.orElse(null);
    }

    public void deletePlayerStats(String id) {
        playerStatsRepository.deleteById(id);

    }

    private void updatePlayerStats(List<TeamPlayerDto> goalScorers) {
        if (goalScorers == null || goalScorers.isEmpty()) {
            return;
        }
        Map<String, Integer> goalScorersMap = new HashMap<>();
        for (TeamPlayerDto t : goalScorers) {
            goalScorersMap.put(t.getStatsId(), goalScorersMap.getOrDefault(t.getStatsId(), 0) + 1);
        }

        for (String i : goalScorersMap.keySet()) {
            PlayerStats playerStats = getPlayerStats(i);

            if (playerStats != null) {
                playerStats.setTotalGoals(playerStats.getTotalGoals() + goalScorersMap.getOrDefault(i, 0));

                playerStatsRepository.save(playerStats);

            }
        }

    }

}
