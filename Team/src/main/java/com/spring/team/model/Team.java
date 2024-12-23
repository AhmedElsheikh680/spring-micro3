package com.spring.team.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.basic.BasicButtonUI;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    private long id;
    private String from;
    private String to;
    private int moneyTeam;
    private String note;
    private String numberOfTeam;

//    public Team(long id, String from, String to, int moneyTeam, String note, String numberOfTeam) {
//        this.id = id;
//        this.from = from;
//        this.to = to;
//        this.moneyTeam = moneyTeam;
//        this.note = note;
//        this.numberOfTeam = numberOfTeam;
//    }
}
