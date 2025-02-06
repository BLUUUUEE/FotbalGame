package com.vkgames.football.Entity.Person.PersonImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Entity.Stats.StatsImpl.PlayerStats;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Player")

public class Player implements Person {
    @Id
    private ObjectId id;
    private ObjectId playerStatsId;
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
