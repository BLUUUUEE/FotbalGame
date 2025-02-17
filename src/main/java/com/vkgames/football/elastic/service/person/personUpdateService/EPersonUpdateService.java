package com.vkgames.football.elastic.service.person.personUpdateService;

import com.vkgames.football.elastic.entity.EPerson;

public interface EPersonUpdateService {
    EPerson updateEPersonService(EPerson oldEPerson, EPerson newEPerson);
}
