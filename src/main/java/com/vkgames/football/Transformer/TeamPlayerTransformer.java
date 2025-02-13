package com.vkgames.football.Transformer;

import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import com.vkgames.football.Mongo.Entity.Person.PersonImpl.Player;

public class TeamPlayerTransformer {

    public static TeamPlayerDto PlayerToTeamPlayerDto(Player player) {
        TeamPlayerDto teamPlayerDto = new TeamPlayerDto();
        teamPlayerDto.setStatsId(player.getPlayerStatsId());
        teamPlayerDto.setName(player.getName());
        teamPlayerDto.setJerseyNumber(player.getJerseyNumber());
        return teamPlayerDto;
    }
}
