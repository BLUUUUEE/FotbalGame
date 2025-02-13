package com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EReferee;
import com.vkgames.football.Elastic.ERepository.EPerson.ERefereeRepository;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageService;
import com.vkgames.football.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ERefereeStorageService implements EPersonStorageService {

    @Autowired
    private ERefereeRepository eRefereeRepository;

    @Override
    public void saveEPerson(EPerson ePerson) {
        EReferee eReferee = (EReferee) ePerson;
        eRefereeRepository.save(eReferee);

    }

    @Override
    public EPerson findEPerson(String id) {
        Optional<EReferee> eReferee = eRefereeRepository.findById(id);
        if (eReferee.isPresent()) {
            return eReferee.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteEPerson(String id) {
        eRefereeRepository.deleteById(id);
    }

    @Override
    public EPerson findEPersonByNameAndRole(String name) {
        return (EPerson) eRefereeRepository.findByName(name);
    }

    @Override
    public List<EPerson> getAll(Role role) {
        Iterable<EReferee> eReferees = eRefereeRepository.findAll();
        List<EPerson> ePersonList = null;
        for (EReferee R : eReferees) {
            ePersonList.add((EPerson) R);
        }
        return ePersonList;
    }
}
