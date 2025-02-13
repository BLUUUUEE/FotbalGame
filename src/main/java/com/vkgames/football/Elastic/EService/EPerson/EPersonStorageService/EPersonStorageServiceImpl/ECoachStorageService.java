package com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.ECoach;
import com.vkgames.football.Elastic.ERepository.EPerson.ECoachRepository;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageService;
import com.vkgames.football.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECoachStorageService implements EPersonStorageService {

    @Autowired
    private ECoachRepository eCoachRepository;

    @Override
    public void saveEPerson(EPerson ePerson) {
        ECoach eCoach = (ECoach) ePerson;
        eCoachRepository.save(eCoach);
    }

    @Override
    public EPerson findEPerson(String id) {
        Optional<ECoach> eCoach = eCoachRepository.findById(id);
        if (eCoach.isPresent()) {
            return eCoach.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteEPerson(String id) {
        eCoachRepository.deleteById(id);
    }

    @Override
    public EPerson findEPersonByNameAndRole(String name) {
        return (EPerson) eCoachRepository.findByName(name);
    }

    @Override
    public List<EPerson> getAll(Role role) {
        Iterable<ECoach> eCoaches = eCoachRepository.findAll();
        List<EPerson> personList = null;
        for (ECoach c : eCoaches) {
            personList.add((EPerson) c);
        }
        return personList;
    }
}
