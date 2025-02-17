package com.vkgames.football.mongo.dto.matchDto;

import com.vkgames.football.mongo.dto.teamDto.MatchTeamDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRequestDto {
    private MatchTeamDto matchTeamDto1;
    private MatchTeamDto matchTeamDto2;
    private String result;
    private String refereeName;
}
