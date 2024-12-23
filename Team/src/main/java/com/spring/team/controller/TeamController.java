package com.spring.team.controller;


import com.spring.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/{from}/player/{to}")
    public ResponseEntity<?> teamWithPlayer(@PathVariable String from, @PathVariable String to) {
        String url ="http://localhost:8888/football/buy/{from}/player/{to}";
        Map<String, String> urlAttributes = new HashMap<>();
        urlAttributes.put("from", from);
        urlAttributes.put("to", to);
            ResponseEntity<?> responseEntity = restTemplate.getForEntity(url, Team.class, urlAttributes);
            Team teamResponse = (Team) responseEntity.getBody();
            return ResponseEntity.ok(Team.builder()
                    .id(teamResponse.getId())
                    .from(teamResponse.getFrom())
                    .to(teamResponse.getTo())
                    .moneyTeam(teamResponse.getMoneyTeam())
                    .note("NONE")
                    .numberOfTeam("50")
                    .build());
//        return ResponseEntity.ok(new Team(teamResponse.getId(), teamResponse.getFrom(),
//                teamResponse.getTo(), teamResponse.getMoneyTeam(), "NONE", "50"));
    }
}
