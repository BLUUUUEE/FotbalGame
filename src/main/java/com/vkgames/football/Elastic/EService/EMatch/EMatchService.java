package com.vkgames.football.Elastic.EService.EMatch;

import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchResponseDto;
import org.bson.types.ObjectId;

public interface EMatchService {
    EMatch createEMatch(MatchRequestDto matchRequestDto);

    EMatch getMatchById(String matchId);
}
