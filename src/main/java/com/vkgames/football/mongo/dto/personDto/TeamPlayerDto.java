package com.vkgames.football.mongo.dto.personDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDto {

    private String statsId;
    private String name;
    private Integer jerseyNumber;
}
