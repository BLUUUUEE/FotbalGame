package com.vkgames.football.elastic.service.match.matchServiceImpl;
import com.vkgames.football.elastic.entity.match.EMatch;
import com.vkgames.football.elastic.repository.EMatchRepository;
import com.vkgames.football.elastic.service.match.EMatchService;
import com.vkgames.football.elastic.service.stats.EStatsServiceHandler;
import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;
import com.vkgames.football.transformer.MatchDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EMatchServiceImpl implements EMatchService {

    @Autowired
    private EMatchRepository eMatchRepository;
    @Autowired
    private EStatsServiceHandler eStatsServiceHandler;

    @Override
    public EMatch createEMatch(MatchRequestDto matchRequestDto,String id) {
        EMatch eMatch = MatchDtoTransformer.matchRequestDtoToEMatch(matchRequestDto,id);
        eMatchRepository.save(eMatch);
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

    @Override
    public List<EMatch> getMatchesBySubstring(String substring) {
        return eMatchRepository.findTeamsContaining(substring);
    }

    @Override
    public void saveEMatch(EMatch eMatch) {
        eMatchRepository.save(eMatch);
    }

    @Override
    public List<EMatch> getMatchByGoals(Integer goals) {
        List<EMatch>matches = eMatchRepository.findMatchesWithGoalsGreaterThanEqualTo(goals);
        return matches;
    }




}
