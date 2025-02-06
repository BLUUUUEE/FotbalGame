package com.vkgames.football.Service.Stats;

import com.vkgames.football.Entity.Match.Match;
import com.vkgames.football.Repository.MatchRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        System.out.println("The match has been completed!!");
        notifyStatsServices(match);

    }

    private void notifyStatsServices(Match match) {

        for (StatsService s : statsServices) {
            s.updateStats(match);
        }
    }

}
