package com.spring.players.controller;

import com.spring.players.config.PlayersStatisticsConfig;
import com.spring.players.model.PlayersStatistics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players-management")
public class PlayersStatisticsController {

    private PlayersStatisticsConfig config;

    public PlayersStatisticsController(PlayersStatisticsConfig config) {
        this.config = config;
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getPlayersStatistics() {
        return ResponseEntity.ok(new PlayersStatistics(config.getNumberOfTeams(), config.getNumberOfPlayers(), config.getCountry()));
    }
}
