package com.vkgames.football.elastic.repository.person;

import com.vkgames.football.elastic.entity.personImpl.EReferee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ERefereeRepository extends ElasticsearchRepository<EReferee,String> {
    EReferee findByName(String name);
}
