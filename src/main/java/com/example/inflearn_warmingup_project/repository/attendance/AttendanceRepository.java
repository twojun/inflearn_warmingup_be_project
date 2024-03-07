package com.example.inflearn_warmingup_project.repository.attendance;

import com.example.inflearn_warmingup_project.domain.attendance.Attendance;
import com.example.inflearn_warmingup_project.dto.attendance.response.UserAttendanceListDtoInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

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

    // 월별 총 근무시간에 사용될 리스트
    @Query("select sum(a.workingMinutes) from Attendance a where a.user.id = :userId")
    List<Integer> calculateWorkingMinutes2(@Param("userId") Long userId);

    // 특정 직원의 월 총 근무시간 계산
    @Query(value =
            "select * " +
            "from attendance " +
            "where user_id= :id " +
            "and year(check_in_date)= :year " +
            "and month(check_in_date)= :month " +
            "group by check_in_date", nativeQuery = true)
    List<Attendance> getUserAttendanceList(@Param("id") Long id,
                                           @Param("year") Integer year,
                                           @Param("month") Integer month);


}
