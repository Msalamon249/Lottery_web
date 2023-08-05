package com.example.lottery_web.domain.resultchecker;


import java.util.List;
import java.util.Optional;

public interface PlayerRespotiory {

    List<Player> saveAll(List<Player> players);

    Optional<Player> findById(String hash);
}
