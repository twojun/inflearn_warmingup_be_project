package com.example.inflearn_warmingup_project.dto.vacation.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAnnualDay {

    private LocalDate workStartDay;
    private int annualDay;
}
