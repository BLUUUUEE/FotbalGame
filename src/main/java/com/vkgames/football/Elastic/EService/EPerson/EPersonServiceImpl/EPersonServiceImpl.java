package com.vkgames.football.Elastic.EService.EPerson.EPersonServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EFactory.EPersonFactory;
import com.vkgames.football.Elastic.EFactory.EPersonFactoryProvider;
import com.vkgames.football.Elastic.EService.EPerson.EPersonService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl.ECoachStorageService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl.EPlayerStorageService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl.ERefereeStorageService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateServiceImpl.ECoachUpdateService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateServiceImpl.EPlayerUpdateService;
import com.vkgames.football.Elastic.EService.EPerson.EPersonUpdateService.EPersonUpdateServiceImpl.ERefereeUpdateService;
import com.vkgames.football.Mongo.Dto.PersonDto.PersonRequestDto;
import com.vkgames.football.Role.Role;
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
