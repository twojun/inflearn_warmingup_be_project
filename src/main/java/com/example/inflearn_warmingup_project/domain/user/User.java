package com.example.inflearn_warmingup_project.domain.user;

import com.example.inflearn_warmingup_project.domain.team.Team;
import com.example.inflearn_warmingup_project.dto.user.request.UserCreateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String name;
    private String teamName;
    private String role;

    private LocalDate birthday;
    private LocalDate workStartDate;

    protected User() {}

    public User(UserCreateRequestDto requestDto, Team team) {
        if (requestDto.getRole().equals("MANAGER") && team.getManager() != null) {
            throw new IllegalStateException("해당 팀의 매니저가 이미 존재합니다.");
        }

        this.name = requestDto.getName();
        this.team = team;
        this.teamName = team.getName();
        this.role = requestDto.getRole();;
        this.birthday = requestDto.getBirthday();
        this.workStartDate = requestDto.getWorkStartDate();
    }
}
