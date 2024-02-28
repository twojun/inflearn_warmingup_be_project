package com.example.inflearn_warmingup_project.repository.team;

import com.example.inflearn_warmingup_project.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String teamName);
}
