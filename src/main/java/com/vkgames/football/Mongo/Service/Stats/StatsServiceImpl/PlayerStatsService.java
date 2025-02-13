package com.vkgames.football.Mongo.Service.Stats.StatsServiceImpl;

import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import com.vkgames.football.Mongo.Entity.Stats.StatsImpl.PlayerStats;
import com.vkgames.football.Mongo.Repository.Stats.PlayerStatsRepository;
import com.vkgames.football.Mongo.Service.Stats.StatsService;
import org.bson.types.ObjectId;
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
    @Override
    public void updateStats(Match match) {

        List<TeamPlayerDto> team1GoalScorers = match.getMatchTeamDto1().getGoalScorers();
        List<TeamPlayerDto> team2GoalScorers = match.getMatchTeamDto2().getGoalScorers();


        updatePlayerStats(team1GoalScorers);
        updatePlayerStats(team2GoalScorers);

    }


    public ObjectId createPlayerStats(String playerName) {

        PlayerStats playerStats = new PlayerStats();
        playerStats.setPlayerName(playerName);

        PlayerStats savedPlayerStats = playerStatsRepository.save(playerStats);
        playerStatsRepository.save(playerStats);

        return savedPlayerStats.getId();

    }

    public PlayerStats getPlayerStats(ObjectId id) {
        Optional<PlayerStats> playerStats = playerStatsRepository.findById(id);
        return playerStats.orElse(null);
    }
    public void deletePlayerStats(ObjectId id){
        playerStatsRepository.deleteById(id);
//        playerStatsElasticRepository.deleteById(id);
    }

    private void updatePlayerStats(List<TeamPlayerDto> goalScorers) {
        if(goalScorers==null || goalScorers.isEmpty()){
            return ;
        }
        Map<ObjectId, Integer> goalScorersMap = new HashMap<>();
        for (TeamPlayerDto t : goalScorers) {
            goalScorersMap.put(t.getStatsId(), goalScorersMap.getOrDefault(t.getStatsId(), 0) + 1);
        }

        for (ObjectId i : goalScorersMap.keySet()) {
            PlayerStats playerStats = getPlayerStats(i);

          if(playerStats!=null)  {
                playerStats.setTotalGoals(playerStats.getTotalGoals() + goalScorersMap.getOrDefault(i, 0));
                playerStats.setMatchesPlayed(playerStats.getMatchesPlayed() + 1);
                playerStatsRepository.save(playerStats);
//                playerStatsElasticRepository.save(playerStats);
            }
        }

    }

}
