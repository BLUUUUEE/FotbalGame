package com.vkgames.football.Elastic.EService.EStats;

import com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl.EPlayerStatsService;
import com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl.ETeamStatsService;
import com.vkgames.football.Mongo.Entity.Match.Match;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EStatsServiceHandler {
    @Autowired
    private EStatsUpdateServiceProvider eStatsUpdateServiceProvider;
    @Autowired
    private EPlayerStatsService ePlayerStatsService;
    @Autowired
    private ETeamStatsService eTeamStatsService;

    @PostConstruct
    private void init() {
        addEStatsServices();  // Runs once after dependencies are injected
    }

    void addEStatsServices() {


        eStatsUpdateServiceProvider.addEStatsService(ePlayerStatsService);
        eStatsUpdateServiceProvider.addEStatsService(eTeamStatsService);
    }

    public void handleUpdateService(Match Match) {
        eStatsUpdateServiceProvider.eMatchHappened(Match);

    }

}
