package com.example.inflearn_warmingup_project.controller.attendance;

import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckInRequestDto;
import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckOutRequestDto;
import com.example.inflearn_warmingup_project.dto.attendance.response.UserAttendanceListDto;
import com.example.inflearn_warmingup_project.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/api/attend/{id}/{year}-{month}")
    public List<UserAttendanceListDto> getUserAttendance(@PathVariable(name = "id") Long id,
                                                         @PathVariable(name = "year") int year,
                                                         @PathVariable(name = "month") int month) {
        return attendanceService.getUserAttendance(id, year, month);
    }

    @PostMapping("/api/attend/check-in/{id}")
    public void checkIn(@PathVariable(name = "id") long id, @RequestBody CreateCheckInRequestDto requestDto) {
        attendanceService.checkIn(id, requestDto);
    }

    @PutMapping("/api/attend/check-out/{id}/{working_minutes}")
    public void checkOut(@PathVariable(name = "id") Long id,
                         @PathVariable(name = "working_minutes") Integer workingMinutes,
                         @RequestBody CreateCheckOutRequestDto requestDto) {
        attendanceService.checkOut(id, workingMinutes, requestDto);
    }
}
