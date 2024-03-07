package com.example.inflearn_warmingup_project.repository.vacation;

import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.domain.vacation.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

    @Query("select v from Vacation v where v.user.id = :id")
    List<Vacation> getUserRemainAnnualDay(Long id);

    boolean existsByUserAndAnnualLeaveDate(User user, LocalDate annualDate);
}


