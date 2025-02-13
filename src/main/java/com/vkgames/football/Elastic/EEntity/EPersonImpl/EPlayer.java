package com.vkgames.football.Elastic.EEntity.EPersonImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "player")
public class EPlayer implements EPerson {
    @Id
    private String id;
    private String EplayerStatsId;
    private String name;
    private long age;
    private String team;
    private String position;
    private Integer jerseyNumber;
    private Float pace;
    private Float physicality;
    private Float shooting;
    private Float passing;
    private Float defending;
    private Float dribbling;
    private Role role=Role.PLAYER;

}
