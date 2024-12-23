package com.spring.football.repo;

import com.spring.football.model.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTeamRepo extends JpaRepository<PlayerTeam, Long> {

    PlayerTeam findByFromAndTo(String from, String to);
}
