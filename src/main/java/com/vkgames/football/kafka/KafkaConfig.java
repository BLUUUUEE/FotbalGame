package com.vkgames.football.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic matchEventsTopic(){
        return new NewTopic("match_events",1,(short) 1);
    }
}
