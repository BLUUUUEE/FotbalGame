package com.vkgames.football.Controller;

import com.vkgames.football.Dto.TeamDto.TeamRequestDto;
import com.vkgames.football.Dto.TeamDto.TeamResponseDto;
import com.vkgames.football.Entity.Team.Team;
import com.vkgames.football.Service.Team.TeamService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping
    ResponseEntity<?> createTeam(@RequestBody TeamRequestDto teamRequestDto) {
        Team team = teamService.createTeam(teamRequestDto);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    ResponseEntity<?> getTeamById(@PathVariable ObjectId id) {
        TeamResponseDto teamResponseDto = teamService.getTeamById(id);
        if (teamResponseDto != null) {
            return new ResponseEntity<>(teamResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{teamName}")
    ResponseEntity<?> getTeamByTeamName(@PathVariable String teamName) {
        Team team = teamService.getTeamByTeamName(teamName);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("id/{id}")
    ResponseEntity<?> updateTeamById(@PathVariable ObjectId id, @RequestBody TeamRequestDto teamRequestDto) {
        Team team = teamService.updateTeam(id, teamRequestDto);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("id/{id}")
    ResponseEntity<?> deleteTeamById(@PathVariable ObjectId id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
