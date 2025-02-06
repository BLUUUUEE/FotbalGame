package com.vkgames.football.Dto.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDto {
    private ObjectId statsId;
    private String name;
    private Integer jerseyNumber;
}
