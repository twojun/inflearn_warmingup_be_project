package com.example.inflearn_warmingup_project.dto.vacation.request;

import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.domain.vacation.Vacation;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetUserRemainAnnualDayRequestDto {

    @NotNull(message = "직원 ID를 입력하셔야 합니다.")
    private Long userId;

    @NotNull(message = "연차 사용 일자를 입력하세요")
    private LocalDate annualDay;

    @Builder
    public Vacation toEntity(User user) {
        return Vacation.builder()
                .annualLeaveDate(annualDay)
                .user(user)
                .build();
    }
}
