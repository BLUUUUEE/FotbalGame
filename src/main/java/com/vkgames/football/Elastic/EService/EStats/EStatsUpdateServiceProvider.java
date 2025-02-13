package com.vkgames.football.Elastic.EService.EStats;

import com.vkgames.football.Elastic.ERepository.EMatchRepository;
import com.vkgames.football.Mongo.Entity.Match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EStatsUpdateServiceProvider {

    private final List<EStatsService> eStatsServices = new ArrayList<>();
    @Autowired
    private EMatchRepository eMatchRepository;

    public void addEStatsService(EStatsService eStatsService) {
        eStatsServices.add(eStatsService);
    }

    public void removeStatsService(EStatsService eStatsService) {
        eStatsServices.remove(eStatsService);
    }

    public void eMatchHappened(Match Match) {
        System.out.println("The match has been completed!!");
        notifyStatsServices(Match);

    }

    private void notifyStatsServices(Match Match) {

        for (EStatsService s : eStatsServices) {
            s.updateEStats(Match);
        }
    }
}
