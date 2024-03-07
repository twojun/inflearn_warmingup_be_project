package com.example.inflearn_warmingup_project.dto.attendance.response;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserAttendanceListDto {

    private LocalDate checkInDate;
    private Integer workingMinutes;
    private Integer allWorkingMinutes;

    public UserAttendanceListDto(Attendance attendance, Integer allWorkingMinutes) {
        this.checkInDate = attendance.getCheckInDate();
        this.workingMinutes = attendance.getWorkingMinutes();
        this.allWorkingMinutes = allWorkingMinutes;
    }
}
