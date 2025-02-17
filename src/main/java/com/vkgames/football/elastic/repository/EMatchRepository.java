package com.vkgames.football.elastic.repository;
import com.vkgames.football.elastic.entity.match.EMatch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EMatchRepository extends ElasticsearchRepository<EMatch,String> {

    @Query("{ \"wildcard\": { \"teams\": \"*?0*\" } }")
    List<EMatch> findTeamsContaining(String substring);

    @Query("{ \"query\": { \"range\": { \"totalGoals\": { \"gte\": ?0 } } } }")
    List<EMatch> findMatchesWithGoalsGreaterThanEqualTo(Integer goals);







}
