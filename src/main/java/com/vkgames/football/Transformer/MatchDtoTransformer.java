package com.vkgames.football.Transformer;

import com.vkgames.football.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Dto.TeamDto.MatchTeamDto;
import com.vkgames.football.Entity.Match.Match;

public class MatchDtoTransformer {
    public static Match matchRequestDtoToMatch(MatchRequestDto matchRequestDto) {
        Match match = new Match();
        match.setMatchTeamDto1(matchRequestDto.getMatchTeamDto1());
        match.setMatchTeamDto2(matchRequestDto.getMatchTeamDto2());
        match.setResult(matchRequestDto.getResult());
        match.setRefereeName(matchRequestDto.getRefereeName());

        return match;
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
