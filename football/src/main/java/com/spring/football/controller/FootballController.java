package com.spring.football.controller;


import com.spring.football.model.PlayerTeam;
import com.spring.football.repo.PlayerTeamRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football")
public class FootballController {
    private PlayerTeamRepo playerTeamRepo;

    public FootballController(PlayerTeamRepo playerTeamRepo) {
        this.playerTeamRepo = playerTeamRepo;
    }

    @GetMapping("/buy/{from}/player/{to}")
    public ResponseEntity<?> buyPlayer(@PathVariable String from, @PathVariable String to) {
//        return ResponseEntity.ok(PlayerTeam.builder()
//                .id(1)
//                .from(from)
//                .to(to)
//                .moneyPlayer(500)
//                .moneyTeam(600)
//                .build()
//        );
        return ResponseEntity.ok(playerTeamRepo.findByFromAndTo(from, to));
    }
}
