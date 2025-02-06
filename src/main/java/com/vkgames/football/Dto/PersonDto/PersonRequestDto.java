package com.vkgames.football.Dto.PersonDto;

import com.vkgames.football.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDto {
    private String name;
    private long age;
    private String team;
    private String position;
    private Integer jerseyNumber;
    private Role role;
    private Float pace;
    private Float physicality;
    private Float shooting;
    private Float passing;
    private Float defending;
    private Float dribbling;
}
