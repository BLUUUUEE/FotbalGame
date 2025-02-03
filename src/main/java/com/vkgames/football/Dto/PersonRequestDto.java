package com.vkgames.football.Dto;

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
   private long jerseyNumber;
   private Role role;
}
