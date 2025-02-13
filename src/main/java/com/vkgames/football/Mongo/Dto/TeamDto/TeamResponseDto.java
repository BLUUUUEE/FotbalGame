package com.vkgames.football.Mongo.Dto.TeamDto;

import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private ObjectId id;
    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon;
    private long matchesLost;
    private long matchesDraw;
}
