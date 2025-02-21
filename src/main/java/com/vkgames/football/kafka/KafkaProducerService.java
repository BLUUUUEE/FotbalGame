package com.vkgames.football.kafka;

import com.vkgames.football.mongo.entity.match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Match> kafkaTemplate;

    public void publishMatchEvent(Match match) {
        System.out.println("producer is active");
        kafkaTemplate.send("match_events", match);
    }


}
