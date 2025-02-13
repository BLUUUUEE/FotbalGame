package com.vkgames.football.Transformer;

import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Mongo.Dto.TeamDto.MatchTeamDto;
import com.vkgames.football.Mongo.Entity.Match.Match;

public class MatchDtoTransformer {
    public static Match matchRequestDtoToMatch(MatchRequestDto matchRequestDto) {
        Match match = new Match();
        match.setMatchTeamDto1(matchRequestDto.getMatchTeamDto1());
        match.setMatchTeamDto2(matchRequestDto.getMatchTeamDto2());
        match.setResult(matchRequestDto.getResult());
        match.setRefereeName(matchRequestDto.getRefereeName());

        return match;
    }
    public static EMatch matchRequestDtoToEMatch(MatchRequestDto matchRequestDto){
        MatchTeamDto matchTeamDto1 = matchRequestDto.getMatchTeamDto1();
        MatchTeamDto matchTeamDto2 = matchRequestDto.getMatchTeamDto2();
        String result = matchRequestDto.getResult();

        EMatch eMatch = new EMatch();
        eMatch.setTeams(matchTeamDto1.getName() + " - " + matchTeamDto2.getName());
        eMatch.setMatchScore(matchTeamDto1.getGoals() + " - " + matchTeamDto2.getGoals());
        eMatch.setPossession(matchTeamDto1.getPossession() + " - " + (100 - (matchTeamDto1.getPossession())));
        eMatch.setShots(matchTeamDto1.getShots() +  matchTeamDto2.getShots());
        eMatch.setYellowCards(matchTeamDto1.getYellowCards() +  matchTeamDto2.getYellowCards());
        eMatch.setRedCards(matchTeamDto1.getRedCards() +  matchTeamDto2.getRedCards());
        eMatch.setFouls(matchTeamDto1.getFouls() +  matchTeamDto2.getFouls());
        eMatch.setCorners(matchTeamDto1.getCorners() +  matchTeamDto2.getCorners());
        eMatch.setSubstitutions(matchTeamDto1.getSubstitutions() +  matchTeamDto2.getSubstitutions());
        if(result.equals("DRAW")){
            eMatch.setResult("DRAW");
        }else{
           if(matchTeamDto1.getGoals()> matchTeamDto1.getGoals()){
               eMatch.setResult("Winner is "+ matchTeamDto1.getName());
           }else{
               eMatch.setResult("Winner is "+ matchTeamDto2.getName());
           }
        }
        eMatch.setRefereeName(matchRequestDto.getRefereeName());
        return eMatch;
    }
    public static MatchResponseDto matchToMatchResponseDto(Match match) {

        MatchTeamDto matchTeamDto1 = match.getMatchTeamDto1();
        MatchTeamDto matchTeamDto2 = match.getMatchTeamDto2();
        String result = match.getResult();
        MatchResponseDto matchResponseDto = new MatchResponseDto();
        matchResponseDto.setTeams(matchTeamDto1.getName() + " - " + matchTeamDto2.getName());
        matchResponseDto.setMatchScore(matchTeamDto1.getGoals() + " - " + matchTeamDto2.getGoals());
        matchResponseDto.setPossession(matchTeamDto1.getPossession() + " - " + (100 - (matchTeamDto1.getPossession())));
        matchResponseDto.setShots(matchTeamDto1.getShots() + " - " + matchTeamDto2.getShots());
        matchResponseDto.setYellowCards(matchTeamDto1.getYellowCards() + " - " + matchTeamDto2.getYellowCards());
        matchResponseDto.setRedCards(matchTeamDto1.getRedCards() + " - " + matchTeamDto2.getRedCards());
        matchResponseDto.setFouls(matchTeamDto1.getFouls() + " - " + matchTeamDto2.getFouls());
        matchResponseDto.setCorners(matchTeamDto1.getCorners() + " - " + matchTeamDto2.getCorners());
        matchResponseDto.setSubstitutions(matchTeamDto1.getSubstitutions() + " - " + matchTeamDto2.getSubstitutions());
        if(result.equals("DRAW")){
            matchResponseDto.setResult("DRAW");
        }else{
           if(matchTeamDto1.getGoals()> matchTeamDto1.getGoals()){
               matchResponseDto.setResult("Winner is "+ matchTeamDto1.getName());
           }else{
               matchResponseDto.setResult("Winner is "+ matchTeamDto2.getName());
           }
        }
        matchResponseDto.setRefereeName(match.getRefereeName());
        return matchResponseDto;


    }
}
