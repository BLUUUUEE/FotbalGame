package com.vkgames.football.Elastic.EEntity.EPersonImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "coach")
public class ECoach implements EPerson {
    @Id
    private String id;
    private String name;
    private long age;
    private String team;
    private Role role = Role.COACH;
}
