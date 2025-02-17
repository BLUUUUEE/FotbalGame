package com.vkgames.football.transformer;

import com.vkgames.football.mongo.dto.personDto.TeamPlayerDto;
import com.vkgames.football.mongo.entity.person.PersonImpl.Player;

public class TeamPlayerTransformer {

    public static TeamPlayerDto PlayerToTeamPlayerDto(Player player) {
        TeamPlayerDto teamPlayerDto = new TeamPlayerDto();
        teamPlayerDto.setStatsId(player.getPlayerStatsId());
        teamPlayerDto.setName(player.getName());
        teamPlayerDto.setJerseyNumber(player.getJerseyNumber());
        return teamPlayerDto;
    }
}
