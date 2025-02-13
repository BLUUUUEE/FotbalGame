package com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService;

import com.vkgames.football.Elastic.EEntity.EPerson;

public interface EPersonUpdateService {
    EPerson updateEPersonService(EPerson oldEPerson, EPerson newEPerson);
}
