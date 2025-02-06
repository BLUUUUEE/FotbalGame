package com.vkgames.football.Dto.MatchDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDto {
    private String teams;
    private String matchScore;
    private String possession;
    private String shots;
    private String yellowCards;
    private String redCards;
    private String fouls;
    private String corners;
    private String substitutions;
    private String result;
    private String refereeName;


}
