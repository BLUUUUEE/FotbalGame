package com.vkgames.football.mongo.repository.person;

import com.vkgames.football.mongo.entity.person.PersonImpl.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Player findByName(String name);
}
