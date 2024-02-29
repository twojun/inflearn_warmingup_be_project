package com.example.inflearn_warmingup_project.controller.attendance;

import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckInRequestDto;
import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckOutRequestDto;
import com.example.inflearn_warmingup_project.dto.attendance.response.UserAttendanceListDto;
import com.example.inflearn_warmingup_project.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

//    @GetMapping("/api/attend/{id}/{date}")
//    public List<UserAttendanceListDto> getUserAttendance(@PathVariable(name = "id") Long id,
//                                                         @PathVariable(name = "date") LocalDate date) {
//        attendanceService.getUserAttendance(id, date);
//    }

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
