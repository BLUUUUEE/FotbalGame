package com.vkgames.football.Elastic.EEntity.EMatch;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "match")
public class EMatch {
    @Id
    private String id;
    private String teams;
    private String matchScore;
    private Integer fouls;
    private String possession;
    private Integer corners;
    private Integer shots;
    private Integer substitutions;
    private Integer redCards;
    private Integer yellowCards;
    private Integer totalGoals;
    private String refereeName;
    private String result;

}
