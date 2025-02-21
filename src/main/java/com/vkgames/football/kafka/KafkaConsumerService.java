package com.vkgames.football.kafka;


import com.vkgames.football.elastic.service.stats.EStatsServiceHandler;
import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.service.stats.StatsServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private StatsServiceHandler statsServiceHandler;
    @Autowired
    private EStatsServiceHandler eStatsServiceHandler;


    @KafkaListener(topics = "match_events", groupId = "my-group")
    public void consumeMatchEvent(Match match) {
        System.out.println("processing match...");
        statsServiceHandler.handleUpdateService(match);
        eStatsServiceHandler.handleUpdateService(match);
        System.out.println("stats Updated!");

    }

}
