package com.example.inflearn_warmingup_project.dto.attendance.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceDto {

    private LocalDate checkInDate;
    private Integer workingMinutes;
}
