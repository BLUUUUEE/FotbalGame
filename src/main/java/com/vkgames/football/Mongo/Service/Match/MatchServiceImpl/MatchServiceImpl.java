package com.vkgames.football.Mongo.Service.Match.MatchServiceImpl;

import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import com.vkgames.football.Mongo.Repository.MatchRepository;
import com.vkgames.football.Mongo.Service.Match.MatchService;
import com.vkgames.football.Mongo.Service.Stats.StatsServiceHandler;
import com.vkgames.football.Transformer.MatchDtoTransformer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private StatsServiceHandler statsServiceHandler;



    @Override
    public Match createMatch(MatchRequestDto matchRequestDto) {
        Match match = MatchDtoTransformer.matchRequestDtoToMatch(matchRequestDto);
        Match savedMatch=matchRepository.save(match);


        statsServiceHandler.handleUpdateService(match);
        return match;
    }

    @Override
    public MatchResponseDto getMatchById(ObjectId matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        if(match.isPresent()){
            return MatchDtoTransformer.matchToMatchResponseDto(match.get());
        }else{
            return null;
        }

    }
}
