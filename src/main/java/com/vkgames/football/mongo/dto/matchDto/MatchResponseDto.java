package com.vkgames.football.mongo.dto.matchDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDto {
    @Id
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
