package com.vkgames.football.elastic.repository.person;

import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.entity.team.ETeam;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EPlayerRepository extends ElasticsearchRepository<EPlayer,String > {
    EPlayer findByName(String name);

//    @Query("{\"match\": {\"team\": {\"query\": \"?0\", \"operator\": \"and\"}}}")
//    List<EPlayer> getPlayersOfTeam(String teamName);

    @Query("{\"match\": {\"team\": {\"query\": \"?0\", \"operator\": \"and\"}}}")
    List<EPlayer> findPlayersOfTeam(String teamName);
}
