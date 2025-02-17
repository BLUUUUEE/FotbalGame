package com.vkgames.football.controller;

import com.vkgames.football.elastic.entity.team.ETeam;
import com.vkgames.football.elastic.service.team.ETeamService;
import com.vkgames.football.mongo.dto.teamDto.TeamRequestDto;
import com.vkgames.football.mongo.entity.team.Team;
import com.vkgames.football.mongo.service.team.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ETeamService eTeamService;

    @PostMapping
    ResponseEntity<?> createTeam(@RequestBody TeamRequestDto teamRequestDto) {
         Team team = teamService.createTeam(teamRequestDto);
        ETeam eTeam = eTeamService.createETeam(teamRequestDto);
        if (eTeam != null) {
            return new ResponseEntity<>(eTeam, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    ResponseEntity<?> getTeamById(@PathVariable String id) {
        ETeam eTeam = eTeamService.getTeamById(id.toString());
        if (eTeam != null) {
            return new ResponseEntity<>(eTeam, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{teamName}")
    ResponseEntity<?> getTeamByTeamName(@PathVariable String teamName) {
        ETeam eTeam = eTeamService.getETeamByTeamName(teamName);
        if (eTeam != null) {
            return new ResponseEntity<>(eTeam, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("id/{id}")
    ResponseEntity<?> updateTeamById(@PathVariable String id, @RequestBody TeamRequestDto teamRequestDto) {
        teamService.updateTeam(id, teamRequestDto);
        ETeam eTeam = eTeamService.updateETeam(id.toString(),teamRequestDto);
        if (eTeam != null) {
            return new ResponseEntity<>(eTeam, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("id/{id}")
    ResponseEntity<?> deleteTeamById(@PathVariable String id) {
        teamService.deleteTeam(id);
        eTeamService.deleteETeam(id.toString());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
