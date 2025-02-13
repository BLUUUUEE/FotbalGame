package com.vkgames.football.Elastic.ERepository.EPerson;

import com.vkgames.football.Elastic.EEntity.EPersonImpl.EReferee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ERefereeRepository extends ElasticsearchRepository<EReferee,String> {
    EReferee findByName(String name);
}
