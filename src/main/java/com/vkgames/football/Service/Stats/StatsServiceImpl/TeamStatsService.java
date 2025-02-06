package com.vkgames.football.Service.Stats.StatsServiceImpl;

import com.vkgames.football.Dto.TeamDto.MatchTeamDto;
import com.vkgames.football.Entity.Match.Match;
import com.vkgames.football.Entity.Stats.StatsImpl.TeamStats;
import com.vkgames.football.Repository.Stats.TeamStatsRepository;
import com.vkgames.football.Service.Stats.StatsService;
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


    public void createTeamStats(String name ){
       TeamStats teamStats = new TeamStats();
       teamStats.setTeamName(name);
      teamStatsRepository.save(teamStats);

    }

    public TeamStats getStatsByTeamName(String name){
      return  teamStatsRepository.findByteamName(name);

    }

    private void updateTeamStats(MatchTeamDto team,String result){
        TeamStats teamStats = teamStatsRepository.findByteamName(team.getName());
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
    }

}
