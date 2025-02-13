package com.vkgames.football.Elastic.EService.EMatch.EMatchServiceImpl;

import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Elastic.ERepository.EMatchRepository;
import com.vkgames.football.Elastic.EService.EMatch.EMatchService;
import com.vkgames.football.Elastic.EService.EStats.EStatsServiceHandler;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Transformer.MatchDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EMatchServiceImpl implements EMatchService {

    @Autowired
    private EMatchRepository eMatchRepository;
    @Autowired
    private EStatsServiceHandler eStatsServiceHandler;

    @Override
    public EMatch createEMatch(MatchRequestDto matchRequestDto) {
        EMatch eMatch = MatchDtoTransformer.matchRequestDtoToEMatch(matchRequestDto);
        EMatch savedEMatch = eMatchRepository.save(eMatch);
        eStatsServiceHandler.handleUpdateService(MatchDtoTransformer.matchRequestDtoToMatch(matchRequestDto));
        return eMatch;
    }

    @Override
    public EMatch getMatchById(String matchId) {
        Optional<EMatch> eMatch = eMatchRepository.findById(matchId);
        if (eMatch.isPresent()) {
            return eMatch.get();
        } else {
            return null;
        }
    }
}
