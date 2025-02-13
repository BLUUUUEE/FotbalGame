package com.vkgames.football.Elastic.ERepository;

import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMatchRepository extends ElasticsearchRepository<EMatch,String> {
}
