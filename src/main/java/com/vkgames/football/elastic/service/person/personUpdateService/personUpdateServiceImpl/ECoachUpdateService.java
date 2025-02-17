package com.vkgames.football.elastic.service.person.personUpdateService.personUpdateServiceImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.ECoach;
import com.vkgames.football.elastic.service.person.personUpdateService.EPersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class ECoachUpdateService implements EPersonUpdateService {

    @Override
    public EPerson updateEPersonService(EPerson oldEPerson, EPerson newEPerson) {
        ECoach oldCoach = (ECoach) oldEPerson;
        ECoach newCoach = (ECoach) newEPerson;

        oldCoach.setName(newCoach.getName() != null ? newCoach.getName() : oldCoach.getName());
        oldCoach.setAge(Math.max(newCoach.getAge(), oldCoach.getAge()));
        oldCoach.setTeam(newCoach.getTeam() != null ? newCoach.getTeam() : oldCoach.getTeam());

        System.out.println("coach updated");
        return (EPerson) oldCoach;
    }
}
