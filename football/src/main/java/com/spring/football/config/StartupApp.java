package com.spring.football.config;

import com.spring.football.model.PlayerTeam;
import com.spring.football.repo.PlayerTeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private PlayerTeamRepo playerTeamRepo;
    @Override
    public void run(String... args) throws Exception {

        if (playerTeamRepo.findAll().isEmpty()) {
            PlayerTeam playerTeam1 = PlayerTeam.builder()
                    .from("BRCA")
                    .to("MDR")
                    .moneyPlayer(500)
                    .moneyTeam(1000)
                    .build();

            PlayerTeam playerTeam2 = PlayerTeam.builder()
                    .from("CITY")
                    .to("UNIT")
                    .moneyPlayer(100)
                    .moneyTeam(500)
                    .build();

            PlayerTeam playerTeam3 = PlayerTeam.builder()
                    .from("ARC")
                    .to("PARS")
                    .moneyPlayer(200)
                    .moneyTeam(7000)
                    .build();
            PlayerTeam playerTeam4= PlayerTeam.builder()
                    .from("TANTA")
                    .to("GIZA")
                    .moneyPlayer(800)
                    .moneyTeam(15000)
                    .build();

            playerTeamRepo.saveAll(Arrays.asList(playerTeam1, playerTeam2, playerTeam3));
        }


    }
}
