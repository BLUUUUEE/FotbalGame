package com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageServiceImpl;

import com.vkgames.football.Elastic.EEntity.EPerson;
import com.vkgames.football.Elastic.EEntity.EPersonImpl.EPlayer;
import com.vkgames.football.Elastic.ERepository.EPerson.EPlayerRepository;
import com.vkgames.football.Elastic.EService.EPerson.EPersonStorageService.EPersonStorageService;
import com.vkgames.football.Elastic.EService.EStats.EStatsServiceImpl.EPlayerStatsService;
import com.vkgames.football.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EPlayerStorageService implements EPersonStorageService {

    @Autowired
    private EPlayerRepository ePlayerRepository;
    @Autowired
    private EPlayerStatsService ePlayerStatsService;


    @Override
    public void saveEPerson(EPerson ePerson) {
        ePlayerRepository.save((EPlayer) ePerson);
    }

    @Override
    public EPerson findEPerson(String id) {
        Optional<EPlayer> ePlayer = ePlayerRepository.findById(id);
        if (ePlayer.isPresent()) {
            return ePlayer.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteEPerson(String id) {
        Optional<EPlayer> ePlayer = ePlayerRepository.findById(id);
        if (ePlayer.isPresent()) {
            ePlayerStatsService.deleteEPlayerStats(ePlayer.get().getEplayerStatsId());
            ePlayerRepository.deleteById(ePlayer.get().getEplayerStatsId());
        }
        ePlayerRepository.deleteById(id);
    }

    @Override
    public EPerson findEPersonByNameAndRole(String name) {
        return (EPerson) ePlayerRepository.findByName(name);
    }

    @Override
    public List<EPerson> getAll(Role role) {
        Iterable<EPlayer> ePlayerList = ePlayerRepository.findAll();
        List<EPerson> ePersonList = null;
        for (EPlayer p : ePlayerList) {
            ePersonList.add((EPerson) p);
        }
        return ePersonList;
    }
}
