package com.example.inflearn_warmingup_project.domain.team;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Team {

    @Id @GeneratedValue
    private Long id;
}
