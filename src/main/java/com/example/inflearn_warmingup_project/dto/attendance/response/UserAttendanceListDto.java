package com.example.inflearn_warmingup_project.dto.attendance.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAttendanceListDto {

    private LocalDate date;
    private Integer workingMinutes;
    private Integer sum;
}
