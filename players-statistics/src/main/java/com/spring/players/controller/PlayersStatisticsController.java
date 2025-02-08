package com.spring.players.controller;

import com.spring.players.config.PlayersStatisticsConfig;
import com.spring.players.model.PlayersStatistics;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/players-management")
public class PlayersStatisticsController {

    Logger logger= LoggerFactory.getLogger(PlayersStatisticsController.class);
    @Autowired
    private RestTemplate restTemplate;

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
//    @Retry(name = "getSalary", fallbackMethod = "callBackk")
    @Retry(name = "resquestsTimes", fallbackMethod = "callBack")
    public String getSalary() {
        logger.info("Request Done================================================================");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:2222/salary", String.class);
        return responseEntity.getBody();
    }

    public String callBack(Exception e) {
        return "Service Unavailable Now!!!!!!!!!!!!!!!!!!!!!!!";
    }

}
