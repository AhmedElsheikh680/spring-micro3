package com.spring.football.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerTeam {

    private long id;
    private String from;
    private String to;
    private int moneyPlayer;
    private int moneyTeam;

}
