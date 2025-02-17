package com.vkgames.football.controller;

import com.vkgames.football.elastic.entity.match.EMatch;
import com.vkgames.football.elastic.service.match.EMatchService;
import com.vkgames.football.mongo.dto.matchDto.MatchRequestDto;
import com.vkgames.football.mongo.entity.match.Match;
import com.vkgames.football.mongo.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private EMatchService eMatchService;

    @PostMapping
    public ResponseEntity<?> createMatch(@RequestBody MatchRequestDto matchRequestDto) {
        Match match = matchService.createMatch(matchRequestDto);
        EMatch eMatch = eMatchService.createEMatch(matchRequestDto, match.getMatchId());

        System.out.println(eMatch);
        eMatchService.saveEMatch(eMatch);
        if (eMatch != null) {
            return new ResponseEntity<>(eMatch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable String matchId) {
        EMatch EMatch = eMatchService.getMatchById(matchId);
        if (EMatch != null) {
            return new ResponseEntity<>(EMatch, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{substring}")
    public ResponseEntity<?> getMatchHavingSubstring(@PathVariable String substring) {
        List<EMatch> eMatches = eMatchService.getMatchesBySubstring(substring.toLowerCase());
        if (eMatches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(eMatches, HttpStatus.OK);
        }
    }

    @GetMapping("/score/{substring}")
    public ResponseEntity<?> getMatchesGoalsMoreThan(@PathVariable Integer goals) {
        List<EMatch> eMatches = eMatchService.getMatchByGoals(goals);
        if(!eMatches.isEmpty()){
            return new ResponseEntity<>(eMatches,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
