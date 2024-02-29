package com.example.inflearn_warmingup_project.repository.attendance;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // 퇴근
    @Query("select a from Attendance a " +
            "where a.user.id = :userId " +
            "and a.checkInDate = :checkInDate " +
            "and a.isStatus = :isStatus")
    Optional<Attendance> getAttendanceInfo(@Param("userId") Long id,
                                           @Param("checkInDate") LocalDate checkInDate,
                                           @Param("isStatus") Boolean isStatus);

    // 근무 시간 계산
    @Query("select sum(a.workingMinutes) from Attendance a where a.user.id = :userId")
    Integer calculateWorkingMinutes(@Param("userId") Long userId);
}
