package com.vkgames.football.Mongo.Service.Stats;

import com.vkgames.football.Mongo.Entity.Match.Match;
import com.vkgames.football.Mongo.Service.Stats.StatsServiceImpl.PlayerStatsService;
import com.vkgames.football.Mongo.Service.Stats.StatsServiceImpl.TeamStatsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatsServiceHandler {
    @Autowired
    private StatsUpdateServiceProvider statsUpdateServiceProvider;
    @Autowired
    private PlayerStatsService playerStatsService;
    @Autowired
    private  TeamStatsService teamStatsService;

    @PostConstruct
    private void init() {
        addStatsServices();  // Runs once after dependencies are injected
    }
   void addStatsServices(){
//       PlayerStatsService playerStatsService = new PlayerStatsService();
//       TeamStatsService teamStatsService = new TeamStatsService();

       statsUpdateServiceProvider.addStatsService(playerStatsService);
       statsUpdateServiceProvider.addStatsService(teamStatsService);
   }

    public void handleUpdateService(Match match){
        statsUpdateServiceProvider.matchHappened(match);

    }

}
