package com.vkgames.football.transformer;


import com.vkgames.football.elastic.entity.match.EMatch;
import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;
import com.vkgames.football.mongo.entity.match.Match;

public class ElasticTransformer {

    public static EMatch matchToEMatch(Match match) {
        EMatch eMatch = new EMatch();
        eMatch.setId(match.getMatchId()); // Deep copy
        eMatch.setMatchTeamDto1(match.getMatchTeamDto1());//shallow copy
        eMatch.setMatchTeamDto2(match.getMatchTeamDto2());
        eMatch.setTeams(match.getMatchTeamDto1().getName() + " vs " + match.getMatchTeamDto2().getName());
        eMatch.setMatchScore(match.getMatchTeamDto1().getGoals() + " - " + match.getMatchTeamDto2().getGoals());
        eMatch.setFouls(match.getMatchTeamDto1().getFouls() + match.getMatchTeamDto2().getFouls());
        eMatch.setPossession(match.getMatchTeamDto1().getPossession() + "-" + (100 - match.getMatchTeamDto1().getPossession()));
        eMatch.setCorners(match.getMatchTeamDto1().getCorners() + match.getMatchTeamDto2().getCorners());
        eMatch.setShots(match.getMatchTeamDto1().getShots() + match.getMatchTeamDto2().getShots());
        eMatch.setSubstitutions(match.getMatchTeamDto1().getSubstitutions() + match.getMatchTeamDto2().getSubstitutions());
        eMatch.setRedCards(match.getMatchTeamDto1().getRedCards() + match.getMatchTeamDto2().getRedCards());
        eMatch.setYellowCards(match.getMatchTeamDto1().getYellowCards() + match.getMatchTeamDto2().getYellowCards());
        eMatch.setTotalGoals(match.getMatchTeamDto1().getGoals() + match.getMatchTeamDto2().getGoals());
        eMatch.setRefereeName(match.getRefereeName());

        return eMatch;
    }
    public static EMatch matchRequestDtoToEMatch(MatchRequestDto matchRequestDto,String id){
        EMatch eMatch = new EMatch();
        eMatch.setId(id);
        eMatch.setMatchTeamDto1(matchRequestDto.getMatchTeamDto1());

        eMatch.setMatchTeamDto2(matchRequestDto.getMatchTeamDto2());
        eMatch.setTeams(matchRequestDto.getMatchTeamDto1().getName() + " vs " + matchRequestDto.getMatchTeamDto2().getName());
        eMatch.setMatchScore(matchRequestDto.getMatchTeamDto1().getGoals() + " - " + matchRequestDto.getMatchTeamDto2().getGoals());
        eMatch.setFouls(matchRequestDto.getMatchTeamDto1().getFouls() + matchRequestDto.getMatchTeamDto2().getFouls());
        eMatch.setPossession(matchRequestDto.getMatchTeamDto1().getPossession() + "-" + (100 - matchRequestDto.getMatchTeamDto1().getPossession()));
        eMatch.setCorners(matchRequestDto.getMatchTeamDto1().getCorners() + matchRequestDto.getMatchTeamDto2().getCorners());
        eMatch.setShots(matchRequestDto.getMatchTeamDto1().getShots() + matchRequestDto.getMatchTeamDto2().getShots());
        eMatch.setSubstitutions(matchRequestDto.getMatchTeamDto1().getSubstitutions() + matchRequestDto.getMatchTeamDto2().getSubstitutions());
        eMatch.setRedCards(matchRequestDto.getMatchTeamDto1().getRedCards() + matchRequestDto.getMatchTeamDto2().getRedCards());
        eMatch.setYellowCards(matchRequestDto.getMatchTeamDto1().getYellowCards() + matchRequestDto.getMatchTeamDto2().getYellowCards());
        eMatch.setTotalGoals(matchRequestDto.getMatchTeamDto1().getGoals() + matchRequestDto.getMatchTeamDto2().getGoals());
        eMatch.setRefereeName(matchRequestDto.getRefereeName());

        return eMatch;

    }

}
