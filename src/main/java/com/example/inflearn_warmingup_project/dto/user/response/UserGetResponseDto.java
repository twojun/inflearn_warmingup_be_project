package com.example.inflearn_warmingup_project.dto.user.response;

import com.example.inflearn_warmingup_project.domain.user.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserGetResponseDto {

    private String name;

    private String teamName;

    private String role;

    private LocalDate birthday;

    private LocalDate workStartDate;

    public UserGetResponseDto(User user) {
        this.name = user.getName();
        this.teamName = user.getTeam().getName();
        this.role = user.getRole();
        this.birthday = user.getBirthday();
        this.workStartDate = user.getWorkStartDate();
    }
}
