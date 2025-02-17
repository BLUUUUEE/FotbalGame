package com.vkgames.football.mongo.entity.person.PersonImpl;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "Coach")
public class Coach implements Person {
    @Id
    private String id;
    private String name;
    private long age;
    private String team;
    private Role role = Role.COACH;

    @Override
    public Role getRole() {
        return role;
    }
}
