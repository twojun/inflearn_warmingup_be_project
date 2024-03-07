package com.example.inflearn_warmingup_project.domain.vacation;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import com.example.inflearn_warmingup_project.domain.basetime.BaseTimeEntity;
import com.example.inflearn_warmingup_project.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vacation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate workStartDay;
    private Integer annualDay;

    @Column(nullable = false)
    private LocalDate annualLeaveDate;

    @Builder
    public Vacation(LocalDate annualLeaveDate, User user) {
        this.annualLeaveDate = annualLeaveDate;
        this.user = user;
    }

    public Vacation(LocalDate workStartDay, int annualDay, User user) {
        this.user = user;
        this.workStartDay = workStartDay;
        this.annualDay = annualDay;
    }

    public void useAnnualDay(LocalDate assignAnnualDay) {
        if (annualDay == 0) {
            throw new IllegalStateException("올해 연차를 모두 사용하였습니다.");
        }

        // annual use validation  : 모든 팀은 연차를 사용하기 전 연차 당일 1일 전에 미리 신청한다.
        LocalDate requestDate = LocalDate.now().minusDays(1);
        if (assignAnnualDay.isBefore(requestDate)) {
            throw new IllegalStateException("연차는 신청일로부터 1일 전에만 신청할 수 있습니다.");
        }
        annualDay--;
    }
}
