package com.vkgames.football.Elastic.ERepository;

import com.vkgames.football.Elastic.EEntity.ETeam.ETeam;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ETeamRepository extends ElasticsearchRepository<ETeam,String> {

    ETeam findByteamName(String name);
}
