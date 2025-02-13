package com.vkgames.football.Elastic.ERepository.EPerson;

import com.vkgames.football.Elastic.EEntity.EPersonImpl.EPlayer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EPlayerRepository extends ElasticsearchRepository<EPlayer,String > {
    EPlayer findByName(String name);
}
