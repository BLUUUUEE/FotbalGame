package com.vkgames.football.elastic.service.person;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.entity.stats.statsImpl.EPlayerStats;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.role.Role;

import java.util.List;

public interface EPersonService {

    EPerson createEPerson(PersonRequestDto personRequestDto);

    EPerson getEPersonByIdAndRole(String id, Role role);

    EPerson updateEPerson(String id, Role role, PersonRequestDto personRequestDto);

    void deleteEPerson(String id, Role role);

    EPerson getEPersonByRoleAndName(Role role, String name);

    List<EPerson> getAll(Role role);

    List<EPlayer>getAllPlayersOfTeam(String teamName);

//    EPlayerStats playerWithMaxGoals();

}
