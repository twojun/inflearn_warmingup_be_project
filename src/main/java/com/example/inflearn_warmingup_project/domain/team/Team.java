package com.example.inflearn_warmingup_project.domain.team;

import com.example.inflearn_warmingup_project.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<>();

    private String name;

    protected Team() {};

    public Team(String name) {
        this.name = name;
    }

    public String getManager() {
        User manager = users.stream()
                .filter(user -> "MANAGER".equals(user.getRole()))
                .findFirst()
                .orElse(null);

        return manager == null ? null : manager.getName();
    }

    public int getMemberCount() {
       return users.size();
    }

}
