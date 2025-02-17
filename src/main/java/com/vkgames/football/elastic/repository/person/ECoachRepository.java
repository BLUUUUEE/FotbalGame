package com.vkgames.football.elastic.repository.person;

import com.vkgames.football.elastic.entity.personImpl.ECoach;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECoachRepository extends ElasticsearchRepository<ECoach,String> {
    ECoach findByName(String name);
}
