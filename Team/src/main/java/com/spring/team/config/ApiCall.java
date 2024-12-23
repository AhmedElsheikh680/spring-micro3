package com.spring.team.config;

import com.spring.team.model.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "foofootballtball", url = "localhost:8888")
public interface ApiCall {

    @GetMapping("/football/buy/{from}/player/{to}")
    Team getFootnallPlayer(@PathVariable String from, @PathVariable String to);
}
