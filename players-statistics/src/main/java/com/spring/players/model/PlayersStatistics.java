package com.spring.players.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersStatistics {

    private int numberOfTeams;
    private int numberOfPlayers;
    private String country;
}
