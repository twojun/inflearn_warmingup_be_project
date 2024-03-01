package com.example.inflearn_warmingup_project.repository.attendance;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import com.example.inflearn_warmingup_project.dto.attendance.response.UserAttendanceListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
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

    // 특정 직원의 월 총 근무시간 계산
    @Query("SELECT a.checkInDate AS date, SUM(a.workingMinutes) AS totalWorkingMinutes " +
            "FROM Attendance a " +
            "WHERE a.user.id = :id " +
            "AND FUNCTION('YEAR', a.checkInDate) = :year " +
            "AND FUNCTION('MONTH', a.checkInDate) = :month " +
            "GROUP BY a.checkInDate")
    Optional<Attendance> getUserAttendanceList(@Param("id") Long id,
                                             @Param("year")  int year,
                                             @Param("month") int month);
}
