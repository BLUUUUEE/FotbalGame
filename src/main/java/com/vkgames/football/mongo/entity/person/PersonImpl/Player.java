package com.vkgames.football.mongo.entity.person.PersonImpl;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "Player")  // MongoDB collection


public class Player implements Person {
    @Id
    private String id;
    private String playerStatsId;
    private String name;
    private long age;
    private String team;
    private String position;
    private Integer jerseyNumber;
    private Role role = Role.PLAYER;
    private Float pace;
    private Float physicality;
    private Float shooting;
    private Float passing;
    private Float defending;
    private Float dribbling;


    @Override
    public Role getRole() {
        return role;
    }
}
