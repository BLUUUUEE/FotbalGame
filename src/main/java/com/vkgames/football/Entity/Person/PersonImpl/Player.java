package com.vkgames.football.Entity.Person.PersonImpl;

import com.vkgames.football.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Player")

public class Player implements Person {
    @Id
    private ObjectId id;
    private String name;
    private long age;
    private String team;
    private String position;
    private long jerseyNumber;
    private Role role=Role.PLAYER;

    @Override
    public Role getRole() {
        return role;
    }
}
