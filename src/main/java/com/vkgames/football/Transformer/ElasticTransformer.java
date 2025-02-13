package com.vkgames.football.Transformer;


import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Mongo.Entity.Match.Match;

public class ElasticTransformer {

    public static EMatch matchToEMatch(Match match){
        EMatch eMatch = new EMatch();
       eMatch.setId(match.getMatchId().toString());
       eMatch.setTeams(match.getMatchTeamDto1().getName()+" vs "+match.getMatchTeamDto2().getName());
       eMatch.setMatchScore(match.getMatchTeamDto1().getGoals() + " - " + match.getMatchTeamDto2().getGoals());
       eMatch.setFouls(match.getMatchTeamDto1().getFouls() + match.getMatchTeamDto2().getFouls());
       eMatch.setPossession(match.getMatchTeamDto1().getPossession()+"-"+(100-match.getMatchTeamDto1().getPossession()));
       eMatch.setCorners(match.getMatchTeamDto1().getCorners()+match.getMatchTeamDto2().getCorners());
       eMatch.setShots(match.getMatchTeamDto1().getShots()+match.getMatchTeamDto2().getShots());
       eMatch.setSubstitutions(match.getMatchTeamDto1().getSubstitutions()+match.getMatchTeamDto2().getSubstitutions());
        eMatch.setRedCards(match.getMatchTeamDto1().getRedCards()+match.getMatchTeamDto2().getRedCards());
        eMatch.setYellowCards(match.getMatchTeamDto1().getYellowCards()+match.getMatchTeamDto2().getYellowCards());
        eMatch.setTotalGoals(match.getMatchTeamDto1().getGoals()+match.getMatchTeamDto2().getGoals());
        eMatch.setRefereeName(match.getRefereeName());

        return eMatch;
    }

//    public  static MatchResponseDto EMatchTOMatchResponseDto(EMatch eMatch){
//        MatchResponseDto matchResponseDto = new MatchResponseDto();
//        matchResponseDto.setTeams(eMatch.getTeams());
//        matchResponseDto.setMatchScore(eMatch.getMatchScore());
//        matchResponseDto.setPossession(eMatch.getPossession());
//        matchResponseDto.setShots(eMatch.getShots());
//        matchResponseDto.setYellowCards(matchTeamDto1.getYellowCards() + " - " + matchTeamDto2.getYellowCards());
//        matchResponseDto.setRedCards(matchTeamDto1.getRedCards() + " - " + matchTeamDto2.getRedCards());
//        matchResponseDto.setFouls(matchTeamDto1.getFouls() + " - " + matchTeamDto2.getFouls());
//        matchResponseDto.setCorners(matchTeamDto1.getCorners() + " - " + matchTeamDto2.getCorners());
//        matchResponseDto.setSubstitutions(matchTeamDto1.getSubstitutions() + " - " + matchTeamDto2.getSubstitutions());
//        if(result.equals("DRAW")){
//            matchResponseDto.setResult("DRAW");
//        }else{
//            if(matchTeamDto1.getGoals()> matchTeamDto1.getGoals()){
//                matchResponseDto.setResult("Winner is "+ matchTeamDto1.getName());
//            }else{
//                matchResponseDto.setResult("Winner is "+ matchTeamDto2.getName());
//            }
//        }
//        matchResponseDto.setRefereeName(eMatch.getRefereeName());
//        return matchResponseDto;
//
//
//    }
}
