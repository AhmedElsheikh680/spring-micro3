package com.spring.players.controller;

import com.spring.players.config.PlayersStatisticsConfig;
import com.spring.players.model.PlayersStatistics;
import io.github.resilience4j.retry.annotation.Retry;
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

//    @GetMapping("/salary")
////    @HystrixCommand(fallbackMethod = "callBackk")
//    @Retry(name = "getSalary", fallbackMethod = "callBack")
//    public String getSalary() {
//        throw new NullPointerException("Error");
//    }
//
//    public String callBackk() {
//        return "Service Unavailable !!!!!!!!!!!!!!";
//    }

    @GetMapping("/salary")
    @Retry(name = "getSalary", fallbackMethod = "callBackk")
    public Integer getSalary() {
        return 1;
    }

    public Integer callBackk(Exception e) {
        return 50000;
    }
}
