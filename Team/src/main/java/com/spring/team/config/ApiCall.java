package com.spring.team.config;

import com.spring.team.model.Team;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "football", url = "localhost:8888")
@FeignClient(name = "football")
@RibbonClient(name = "football")
public interface ApiCall {

    @GetMapping("/football/buy/{from}/player/{to}")
    Team getFootnallPlayer(@PathVariable String from, @PathVariable String to);
}
