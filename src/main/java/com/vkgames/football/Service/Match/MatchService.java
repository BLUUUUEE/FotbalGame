package com.vkgames.football.Service.Match;

import com.vkgames.football.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Entity.Match.Match;
import org.bson.types.ObjectId;

public interface MatchService {
    Match createMatch(MatchRequestDto matchRequestDto);

    MatchResponseDto getMatchById(ObjectId matchId);

}
