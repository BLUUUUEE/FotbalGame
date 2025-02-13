package com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Mongo.Entity.Person.Person;
import com.vkgames.football.Role.Role;
import org.bson.types.ObjectId;

import java.util.List;

public interface EPersonStorageService {

    void saveEPerson(EPerson ePerson);

    EPerson findEPerson(String id);

    void deleteEPerson(String id);

    EPerson findEPersonByNameAndRole(String name);

    List<EPerson> getAll(Role role);

}
