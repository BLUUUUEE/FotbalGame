package com.vkgames.football.mongo.entity.person.PersonImpl;

import com.vkgames.football.mongo.entity.person.Person;
import com.vkgames.football.role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "Referee")  // MongoDB collection

public class Referee implements Person {
    @Id
    private String id;
    private String name;
    private long age;
    //    private String team=null;
//    private String position=null;
//    private  long jerseyNumber=0;
    private Role role = Role.REFEREE;

    @Override
    public Role getRole() {
        return role;
    }
}
