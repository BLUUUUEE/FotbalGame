package com.vkgames.football.Controller;
import com.vkgames.football.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Entity.Match.Match;
import com.vkgames.football.Service.Match.MatchService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<?> createMatch(@RequestBody MatchRequestDto matchRequestDto) {
        Match match = matchService.createMatch(matchRequestDto);
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable ObjectId matchId) {
        MatchResponseDto matchResponseDto = matchService.getMatchById(matchId);
        if (matchResponseDto != null) {
            return new ResponseEntity<>(matchResponseDto, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
