package com.vkgames.football.elastic.service.match;

import com.vkgames.football.elastic.entity.match.EMatch;
import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;

import java.util.List;

public interface EMatchService {
    EMatch createEMatch(MatchRequestDto matchRequestDto, String id);

    EMatch getMatchById(String matchId);

    List<EMatch> getMatchesBySubstring(String substring);

    void saveEMatch(EMatch eMatch);

    List<EMatch> getMatchByGoals(Integer goals);

    EMatch saveEMatch(MatchRequestDto matchRequestDto,String id);
}
