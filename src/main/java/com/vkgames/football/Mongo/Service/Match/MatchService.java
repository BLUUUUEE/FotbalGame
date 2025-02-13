package com.vkgames.football.Mongo.Service.Match;

import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import org.bson.types.ObjectId;

public interface MatchService {
    Match createMatch(MatchRequestDto matchRequestDto);

    MatchResponseDto getMatchById(ObjectId matchId);

}
