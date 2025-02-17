package com.vkgames.football.elastic.service.person.personStorageService;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.role.Role;

import java.util.List;

public interface EPersonStorageService {

    void saveEPerson(EPerson ePerson);

    EPerson findEPerson(String id);

    void deleteEPerson(String id);

    EPerson findEPersonByNameAndRole(String name);

    List<EPerson> getAll(Role role);

}
