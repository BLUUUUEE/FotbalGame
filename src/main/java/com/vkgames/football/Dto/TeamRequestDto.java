package com.vkgames.football.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequestDto {
    private ObjectId id;
    private String teamName;
    private String coachName;
    private List<TeamPlayerDto> teamPlayers;
    private String formation;
    private long matchesWon;
    private long matchesLost;
    private long matchesDraw;
}
