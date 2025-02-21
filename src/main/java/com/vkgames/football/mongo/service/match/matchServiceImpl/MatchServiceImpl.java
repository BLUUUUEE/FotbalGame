package com.vkgames.football.mongo.service.match.matchServiceImpl;

import com.vkgames.football.elastic.repository.EMatchRepository;
import com.vkgames.football.elastic.service.stats.EStatsServiceHandler;
import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;
import com.vkgames.football.mongo.dto.matchDto.MatchResponseDto;
import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.repository.MatchRepository;
import com.vkgames.football.mongo.service.match.MatchService;
import com.vkgames.football.mongo.service.stats.StatsServiceHandler;
import com.vkgames.football.transformer.MatchDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private StatsServiceHandler statsServiceHandler;
    @Autowired
    private EMatchRepository eMatchRepository;
    @Autowired
    private EStatsServiceHandler eStatsServiceHandler;



    @Override
    public Match createMatch(MatchRequestDto matchRequestDto) {
        Match match = MatchDtoTransformer.matchRequestDtoToMatch(matchRequestDto);
        Match savedMatch=matchRepository.save(match);
        statsServiceHandler.handleUpdateService(savedMatch);
        return savedMatch;
    }

    @Override
    public MatchResponseDto getMatchById(String matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        if(match.isPresent()){
            return MatchDtoTransformer.matchToMatchResponseDto(match.get());
        }else{
            return null;
        }

    }

    @Override
    public Match saveMatch(MatchRequestDto matchRequestDto) {
        Match match = MatchDtoTransformer.matchRequestDtoToMatch(matchRequestDto);
       Match savedMatch = matchRepository.save(match);
       return savedMatch;
    }
}
