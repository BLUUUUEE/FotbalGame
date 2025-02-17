package com.vkgames.football.elastic.service.person.personServiceImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.entity.stats.statsImpl.EPlayerStats;
import com.vkgames.football.elastic.factory.EPersonFactory;
import com.vkgames.football.elastic.factory.EPersonFactoryProvider;
import com.vkgames.football.elastic.repository.person.EPlayerRepository;
import com.vkgames.football.elastic.repository.stats.EPlayerStatsRepository;
import com.vkgames.football.elastic.service.person.EPersonService;
import com.vkgames.football.elastic.service.person.personStorageService.EPersonStorageService;
import com.vkgames.football.elastic.service.person.personStorageService.personStoragesServiceImpl.ECoachStorageService;
import com.vkgames.football.elastic.service.person.personStorageService.personStoragesServiceImpl.EPlayerStorageService;
import com.vkgames.football.elastic.service.person.personStorageService.personStoragesServiceImpl.ERefereeStorageService;
import com.vkgames.football.elastic.service.person.personUpdateService.EPersonUpdateService;
import com.vkgames.football.elastic.service.person.personUpdateService.personUpdateServiceImpl.ECoachUpdateService;
import com.vkgames.football.elastic.service.person.personUpdateService.personUpdateServiceImpl.EPlayerUpdateService;
import com.vkgames.football.elastic.service.person.personUpdateService.personUpdateServiceImpl.ERefereeUpdateService;
import com.vkgames.football.mongo.dto.personDto.PersonRequestDto;
import com.vkgames.football.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EPersonServiceImpl implements EPersonService {

    @Autowired
    private EPersonFactoryProvider ePersonFactoryProvider;
    @Autowired
    private EPlayerStorageService ePlayerStorageService;
    @Autowired
    private ERefereeStorageService eRefereeStorageService;
    @Autowired
    private ECoachStorageService eCoachStorageService;
    @Autowired
    private EPlayerUpdateService ePlayerUpdateService;
    @Autowired
    private ECoachUpdateService eCoachUpdateService;
    @Autowired
    private ERefereeUpdateService eRefereeUpdateService;
    @Autowired
    private EPlayerRepository ePlayerRepository;
    @Autowired
    private EPlayerStatsRepository ePlayerStatsRepository;

    @Override
    public EPerson createEPerson(PersonRequestDto personRequestDto) {
        EPersonFactory ePersonFactory = ePersonFactoryProvider.getEFactory(personRequestDto.getRole());
        EPerson ePerson = ePersonFactory.createEPerson(personRequestDto);

        EPersonStorageService ePersonStorageService = getEPersonStorageService(personRequestDto.getRole());
        ePersonStorageService.saveEPerson(ePerson);

        return ePerson;
    }

    @Override
    public EPerson getEPersonByIdAndRole(String id, Role role) {
        EPersonStorageService ePersonStorageService = getEPersonStorageService(role);

        return ePersonStorageService.findEPerson(id);
    }

    @Override
    public EPerson updateEPerson(String id, Role role, PersonRequestDto personRequestDto) {
        EPersonStorageService ePersonStorageService = getEPersonStorageService(role);
        EPerson oldPerson = ePersonStorageService.findEPerson(id);
        EPersonFactory ePersonFactory = ePersonFactoryProvider.getEFactory(personRequestDto.getRole());
        EPerson newPerson = ePersonFactory.createEPerson(personRequestDto);

        EPersonUpdateService ePersonUpdateService = getEUpdateService(personRequestDto.getRole());
        oldPerson = ePersonUpdateService.updateEPersonService(oldPerson, newPerson);
        ePersonStorageService.saveEPerson(oldPerson);
        return oldPerson;
    }

    @Override
    public void deleteEPerson(String id, Role role) {
        EPersonStorageService ePersonStorageService = getEPersonStorageService(role);

        if (ePersonStorageService != null) {
            ePersonStorageService.deleteEPerson(id);
        }
    }

    @Override
    public EPerson getEPersonByRoleAndName(Role role, String name) {
        EPersonStorageService ePersonStorageService = getEPersonStorageService(role);
        return ePersonStorageService.findEPersonByNameAndRole(name);
    }

    @Override
    public List<EPerson> getAll(Role role) {
        EPersonStorageService ePersonStorageService = getEPersonStorageService(role);
        return ePersonStorageService.getAll(role);
    }

    @Override
    public List<EPlayer> getAllPlayersOfTeam(String teamName) {
        List<EPlayer>ePlayers = ePlayerRepository.findPlayersOfTeam(teamName);
        return ePlayers;
    }

//    @Override
//    public EPlayerStats playerWithMaxGoals() {
//        EPlayerStats ePlayerStats = ePlayerStatsRepository.findPlayerWithMaxGoals();
//        if(ePlayerStats!=null){
//            return ePlayerStats;
//        }else{
//            return null;
//        }
//
//    }

    private EPersonStorageService getEPersonStorageService(Role role) {
        switch (role) {
            case PLAYER:
                return ePlayerStorageService;
            case REFEREE:
                return eRefereeStorageService;
            case COACH:
                return eCoachStorageService;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }


    }

    private EPersonUpdateService getEUpdateService(Role role) {
        switch (role) {
            case PLAYER:
                return ePlayerUpdateService;
            case REFEREE:
                return eRefereeUpdateService;
            case COACH:
                return eCoachUpdateService;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }


    }
}
