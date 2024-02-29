package com.example.inflearn_warmingup_project.dto.attendance.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCheckInRequestDto {

    private String name;
    private String teamName;
    private LocalDate checkInDate;
}
