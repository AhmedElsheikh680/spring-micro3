package com.spring.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//@EnableHystrix
//@EnableRetry
public class PlayersStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayersStatisticsApplication.class, args);
    }

}
