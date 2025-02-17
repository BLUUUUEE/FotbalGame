package com.vkgames.football.mongo.service.stats.statsServiceImpl;

import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.mongo.dto.teamDto.MatchTeamDto;
import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.entity.stats.StatsImpl.TeamStats;
import com.vkgames.football.mongo.repository.stats.TeamStatsRepository;
import com.vkgames.football.mongo.service.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamStatsService implements StatsService {
    @Autowired
    private TeamStatsRepository teamStatsRepository;

    @Override
    public void updateStats(Match match) {
        MatchTeamDto team1 = match.getMatchTeamDto1();
        MatchTeamDto team2 = match.getMatchTeamDto2();


        String result= match.getResult();

        updateTeamStats(team1,result);
        updateTeamStats(team2,result);

    }


    public TeamStats createTeamStats(String name ){
       TeamStats teamStats = new TeamStats();
       teamStats.setTeamName(name);
       teamStats.setId(IdGenerator.generateIdForTeamStats(name));
      return teamStatsRepository.save(teamStats);


    }

    public TeamStats getStatsByTeamName(String name){
      return  teamStatsRepository.findByteamName(name);

    }

    public void deleteStatsByName(String name){

        teamStatsRepository.deleteByteamName(name);

    }
    private void updateTeamStats(MatchTeamDto team,String result){
        TeamStats teamStats = teamStatsRepository.findByteamName(team.getName());
        teamStats.setMatchesPlayed(teamStats.getMatchesPlayed()+1);
            if(result.equals("DRAW")){
                teamStats.setMatchedDraw(teamStats.getMatchedDraw()+1);
            }else{
                if(result.equals(team.getName())){
                    teamStats.setMatchesWon(teamStats.getMatchesWon()+1);
                }else{
                    teamStats.setMatchesLost(teamStats.getMatchesLost()+1);
                }
            }
            teamStatsRepository.save(teamStats);
//            teamStatsElasticRepository.save(teamStats);
    }

}
