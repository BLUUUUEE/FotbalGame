package com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EReferee;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateService;
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
