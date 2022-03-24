package com.example.football.repository;

import com.example.football.models.dto.BestPlayerDto;
import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT NEW com.example.football.models.dto" +
            ".BestPlayerDto(p.firstName, p.lastName, p.position, t.name, t.stadiumName) " +
            "FROM Player p JOIN p.stat s " +
            "JOIN p.team t " +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastName")
    List<BestPlayerDto> findBestPlayers();
}
