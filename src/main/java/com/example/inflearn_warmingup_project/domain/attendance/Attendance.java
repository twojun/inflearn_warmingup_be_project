package com.example.inflearn_warmingup_project.domain.attendance;

import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.domain.vacation.Vacation;
import com.example.inflearn_warmingup_project.dto.attendance.request.CreateCheckInRequestDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Attendance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attend_id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String teamName;
    private LocalDate checkInDate;
    private Integer workingMinutes;
    private Integer sumMinutes = 0;
    private Boolean isStatus = true;

    public Attendance(User user, CreateCheckInRequestDto requestDto) {
        this.user =  user;
        this.name = requestDto.getName();
        this.teamName = requestDto.getTeamName();
        this.checkInDate = requestDto.getCheckInDate();
    }

    protected Attendance() {}

    // 퇴근 시 근무시간 저장
    public void setWorkingMinutesWithCheckOut(Integer workingMinutes) {
        this.workingMinutes = workingMinutes;
    }

    // 퇴근 시 당일까지 일하게 된 총 근무시간 저장
    public void changeAttendStatus(Integer sumMinutes) {
        this.isStatus = false;
        this.sumMinutes = sumMinutes;
    }

    // 연차 사용
    public void setWorkingMinutesWithAnnualDay(LocalDate assignAnnualDay) {
        workingMinutes = 0;
    }
}
