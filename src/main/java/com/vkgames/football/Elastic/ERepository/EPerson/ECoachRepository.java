package com.vkgames.football.Elastic.ERepository.EPerson;

import com.vkgames.football.Elastic.EEntity.EPersonImpl.ECoach;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECoachRepository extends ElasticsearchRepository<ECoach,String> {
    ECoach findByName(String name);
}
