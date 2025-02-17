package com.vkgames.football.elastic.service.person.personStorageService.personStoragesServiceImpl;

import com.vkgames.football.elastic.entity.EPerson;
import com.vkgames.football.elastic.entity.personImpl.EPlayer;
import com.vkgames.football.elastic.repository.person.EPlayerRepository;
import com.vkgames.football.elastic.service.person.personStorageService.EPersonStorageService;
import com.vkgames.football.elastic.service.stats.statsServiceImpl.EPlayerStatsService;
import com.vkgames.football.utils.IdGenerator;
import com.vkgames.football.role.Role;
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
       EPlayer ePlayer =  (EPlayer) ePerson;
        ePlayer.setId(IdGenerator.generateIdForPlayer(ePlayer.getName(),ePlayer.getTeam(),ePlayer.getJerseyNumber()));
        ePlayerRepository.save(ePlayer);
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
