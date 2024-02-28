package com.example.inflearn_warmingup_project.dto.user.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateRequestDto {

    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public void isValidValue() {
        if (this.name.isEmpty() || this.workStartDate == null || this.birthday == null || this.role.isEmpty()) {
            throw new IllegalStateException("필수 값들을 모두 입력하세요.");
        }

        if (!this.role.equals("MANAGER") && !this.role.equals("MEMBER")) {
            throw new IllegalStateException("임직원은 MEMBER 또는 MANAGER입니다.");
        }
    }

}
