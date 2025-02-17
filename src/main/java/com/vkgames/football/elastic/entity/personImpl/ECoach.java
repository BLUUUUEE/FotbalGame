package com.vkgames.football.elastic.entity.personImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "coach")
public class ECoach implements EPerson {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    private String name;
    private long age;
    private String team;
    private Role role = Role.COACH;
}
