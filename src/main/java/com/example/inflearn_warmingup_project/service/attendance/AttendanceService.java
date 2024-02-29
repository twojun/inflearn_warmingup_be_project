package com.example.inflearn_warmingup_project.service.attendance;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckInRequestDto;
import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckOutRequestDto;
import com.example.inflearn_warmingup_project.repository.attendance.AttendanceRepository;
import com.example.inflearn_warmingup_project.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public void getUserAttendance(Long id, LocalDate date) {
        attendanceRepository.getUserAttendanceList(id, date)
    }

    @Transactional
    public void checkIn(long id, CreateCheckInRequestDto requestDto) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 직원입니다. 다시 확인해 주세요."));
        attendanceRepository.save(new Attendance(findUser, requestDto));
    }

    @Transactional
    public void checkOut(Long id, Integer workingMinutes, CreateCheckOutRequestDto requestDto) {

        Attendance findAttendance = attendanceRepository.getAttendanceInfo(id, requestDto.getCheckInDate(), true)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 출근 정보입니다."));

        findAttendance.setWorkingMinutesWithCheckOut(workingMinutes);
        findAttendance.changeAttendStatus(attendanceRepository.calculateWorkingMinutes(id));
    }
}
