package com.vkgames.football.Elastic.EEntity.EPersonImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Role.Role;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "referee")
public class EReferee implements EPerson {
    @Id
    private ObjectId id;
    private String name;
    private long age;
    private Role role = Role.REFEREE;

}
