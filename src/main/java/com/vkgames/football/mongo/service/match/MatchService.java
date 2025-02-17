package com.vkgames.football.mongo.service.match;

import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;
import com.vkgames.football.mongo.dto.matchDto.MatchResponseDto;
import com.vkgames.football.mongo.entity.match.Match;

public interface MatchService {
    Match createMatch(MatchRequestDto matchRequestDto);

    MatchResponseDto getMatchById(String matchId);

}
