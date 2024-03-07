package com.example.inflearn_warmingup_project.controller.vacation;

import com.example.inflearn_warmingup_project.dto.vacation.request.CreateAnnualDay;
import com.example.inflearn_warmingup_project.dto.vacation.response.UserRemainAnnualDayResultDto;
import com.example.inflearn_warmingup_project.service.vacation.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VacationController {

    private final VacationService vacationService;

    // 연차 초기 세팅
    @PostMapping("/api/v1/vacation/{id}")
    public void createAnnualDay(@PathVariable(name = "id") Long id, @RequestBody CreateAnnualDay requestDto) {
        vacationService.createAnnualDay(id, requestDto);
    }

    @GetMapping("/api/v1/vacation/{id}")
    public List<UserRemainAnnualDayResultDto> getUserRemainAnnualDay(@PathVariable(name = "id") Long id) {
        return vacationService.getUserRemainAnnualDay(id);
    }
}
