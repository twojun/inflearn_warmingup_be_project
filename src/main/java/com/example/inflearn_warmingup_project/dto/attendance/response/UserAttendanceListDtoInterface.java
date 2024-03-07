package com.example.inflearn_warmingup_project.dto.attendance.response;

import java.time.LocalDate;

public interface UserAttendanceListDtoInterface {

     LocalDate getWorkingDate();
     Integer getWorkingMinutes();
}
