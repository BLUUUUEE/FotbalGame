package com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EPlayer;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateService;
import org.springframework.stereotype.Service;

@Service
public class EPlayerUpdateService implements EPersonUpdateService {


    @Override
    public EPerson updateEPersonService(EPerson oldEPerson, EPerson newEPerson) {
        EPlayer oldPlayer = (EPlayer) oldEPerson;
        EPlayer newPlayer = (EPlayer) newEPerson;

        oldPlayer.setName(newPlayer.getName() != null
                ? newPlayer.getName()
                : oldPlayer.getName());
//        System.out.println(oldPlayer.getName());
        oldPlayer.setAge(Math.max(newPlayer.getAge(), oldPlayer.getAge()));
        oldPlayer.setTeam(newPlayer.getTeam() != null
                ? newPlayer.getTeam()
                : oldPlayer.getTeam());

        System.out.println(oldPlayer.getTeam());
        oldPlayer.setPosition(newPlayer.getPosition() != null
                ? newPlayer.getPosition()
                : oldPlayer.getPosition());
        oldPlayer.setJerseyNumber(newPlayer.getJerseyNumber() > 0
                ? newPlayer.getJerseyNumber()
                : oldPlayer.getJerseyNumber());

        oldPlayer.setDribbling(Math.max(oldPlayer.getDribbling(), newPlayer.getDribbling()));
        oldPlayer.setPace(Math.max(oldPlayer.getPace(), newPlayer.getPace()));
        oldPlayer.setDefending(Math.max(oldPlayer.getDefending(), newPlayer.getDefending()));
        oldPlayer.setPassing(Math.max(oldPlayer.getPassing(), newPlayer.getPassing()));
        oldPlayer.setPhysicality(Math.max(oldPlayer.getPhysicality(), newPlayer.getPhysicality()));
        oldPlayer.setShooting(Math.max(oldPlayer.getShooting(), newPlayer.getShooting()));

        System.out.println("player updated!!");
        return (EPerson) oldPlayer;
    }
}
