package com.vkgames.football.Mongo.Entity.Person.PersonImpl;

import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "Coach")
public class Coach implements Person {
    @Id
    private ObjectId id;
    private String name;
    private long age;
    private String team;
    private Role role = Role.COACH;

    @Override
    public Role getRole() {
        return role;
    }
}
