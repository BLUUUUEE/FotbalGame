package com.vkgames.football.Mongo.Dto.TeamDto;

import com.vkgames.football.Mongo.Dto.PersonDto.TeamPlayerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchTeamDto {
    private String name;
    private String coach;
    private Integer goals = 0;
    private List<TeamPlayerDto>goalScorers;
    private Integer yellowCards = 0;
    private Integer redCards = 0;
    private Integer fouls = 0;
    private Integer corners = 0;
    private Integer substitutions = 0;
    private Integer possession = 0;
    private Integer shots = 0;



}
