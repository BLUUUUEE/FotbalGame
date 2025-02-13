package com.vkgames.football.Elastic.EService.EPerson;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface EPersonService {

    EPerson createEPerson(PersonRequestDto personRequestDto);

    EPerson getEPersonByIdAndRole(String id, Role role);

    EPerson updateEPerson(String id, Role role, PersonRequestDto personRequestDto);

    void deleteEPerson(String id, Role role);

    EPerson getEPersonByRoleAndName(Role role, String name);

    List<EPerson> getAll(Role role);
}
