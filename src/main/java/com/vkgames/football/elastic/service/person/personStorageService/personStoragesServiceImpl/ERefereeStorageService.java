package com.vkgames.football.elastic.service.person.personStorageService.personStoragesServiceImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EReferee;
import com.vkgames.football.elastic.repository.person.ERefereeRepository;
import com.vkgames.football.elastic.service.person.personStorageService.EPersonStorageService;
import com.vkgames.football.role.Role;
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
