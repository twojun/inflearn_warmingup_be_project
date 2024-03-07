package com.example.inflearn_warmingup_project.dto.vacation.response;

import com.example.inflearn_warmingup_project.domain.vacation.Vacation;
import lombok.Data;

@Data
public class UserRemainAnnualDayResultDto {

    private Integer annualDay;

    public UserRemainAnnualDayResultDto(Vacation vacation) {
        this.annualDay = vacation.getAnnualDay();
    }
}
