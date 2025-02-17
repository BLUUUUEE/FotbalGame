package com.vkgames.football.elastic.service.person.personUpdateService.personUpdateServiceImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EReferee;
import com.vkgames.football.elastic.service.person.personUpdateService.EPersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class ERefereeUpdateService implements EPersonUpdateService {
    @Override
    public EPerson updateEPersonService(EPerson oldEPerson, EPerson newEPerson) {
        EReferee newRef = (EReferee) oldEPerson;
        EReferee oldRef = (EReferee) newEPerson;

        oldRef.setName(newRef.getName() != null ? newRef.getName() : oldRef.getName());
        oldRef.setAge(Math.max(oldRef.getAge(), newRef.getAge()));

        System.out.println("referee updated!!");
        return (EPerson) oldRef;
    }
}
