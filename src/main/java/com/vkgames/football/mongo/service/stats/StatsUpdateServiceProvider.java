package com.vkgames.football.mongo.service.stats;

import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatsUpdateServiceProvider {

    private final List<StatsService> statsServices = new ArrayList<>();
    @Autowired
    private MatchRepository matchRepository;

    public void addStatsService(StatsService statsService) {
        statsServices.add(statsService);
    }

    public void removeStatsService(StatsService statsService) {
        statsServices.remove(statsService);
    }

    public void matchHappened(Match match) {
        System.out.println("The EMatch has been completed!!");
        notifyStatsServices(match);

    }

    private void notifyStatsServices(Match match) {

        for (StatsService s : statsServices) {
            s.updateStats(match);
        }
    }

}
