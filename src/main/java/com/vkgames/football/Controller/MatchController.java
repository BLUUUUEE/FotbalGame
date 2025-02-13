package com.vkgames.football.Controller;
import com.vkgames.football.Elastic.EEntity.EMatch.EMatch;
import com.vkgames.football.Elastic.EService.EMatch.EMatchService;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchRequestDto;
import com.vkgames.football.Mongo.Dto.MatchDto.MatchResponseDto;
import com.vkgames.football.Mongo.Entity.Match.Match;
import com.vkgames.football.Mongo.Service.Match.MatchService;
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
    @Autowired
    private EMatchService eMatchService;

    @PostMapping
    public ResponseEntity<?> createMatch(@RequestBody MatchRequestDto matchRequestDto) {
         matchService.createMatch(matchRequestDto);
         EMatch eMatch = eMatchService.createEMatch(matchRequestDto);
        if (eMatch != null) {
            return new ResponseEntity<>(eMatch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{matchId}")
    public ResponseEntity<?> getMatchById(@PathVariable ObjectId matchId) {
        EMatch eMatch = eMatchService.getMatchById(matchId.toString());
        if (eMatch != null) {
            return new ResponseEntity<>(eMatch, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
