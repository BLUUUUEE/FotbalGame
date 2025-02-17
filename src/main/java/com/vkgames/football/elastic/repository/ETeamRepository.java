package com.vkgames.football.elastic.repository;

import com.vkgames.football.elastic.entity.team.ETeam;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ETeamRepository extends ElasticsearchRepository<ETeam,String> {

    ETeam findByteamName(String name);




}
