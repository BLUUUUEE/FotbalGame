package com.vkgames.football.elastic.entity.personImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "player")
public class EPlayer implements EPerson {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Keyword)
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
