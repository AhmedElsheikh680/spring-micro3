package com.spring.players.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "players-statistics")
@Data
public class PlayersStatisticsConfig {

    private int numberOfTeams;
    private int numberOfPlayers;
    private String country;
}
