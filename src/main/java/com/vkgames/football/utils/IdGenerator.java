package com.vkgames.football.utils;

import java.time.LocalDateTime;

public class IdGenerator {

    public static String generateIdForPlayer(String name, String teamName, Integer jerseyNumber){
        String nameLowerCase = name.toLowerCase();
        String teamNameLowerCase = teamName.toLowerCase();

        return nameLowerCase+"_"+jerseyNumber+"_"+teamNameLowerCase;
    }

    public static String generateIdForCoach(String name){
            return  name.toLowerCase();
    }

    public static String generateIdForReferee(String name ){
        return name.toLowerCase();
    }

    public static String generateIdForTeam(String teamName){
        return teamName.toLowerCase();
    }

    public static String generateIdForMatch(String team1Name, String team2Name){
        return team1Name.toLowerCase()+"_"+team2Name.toLowerCase()+"_"+ LocalDateTime.now().toString();
    }
    public static String generateIdForPlayerStats(String playerName,long age,String position){
            return "player_stats_"+playerName.toLowerCase()+"_"+Long.toString(age) +"_"+ position.toLowerCase();
    }


    public static String generateIdForTeamStats(String teamName){
        return "team_stats_"+teamName.toLowerCase();
    }


}
