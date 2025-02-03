package com.vkgames.football.Dto;

import com.vkgames.football.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDto {

    private String name;
    private long jerseyNumber;

}
