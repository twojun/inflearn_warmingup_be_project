package com.example.inflearn_warmingup_project.service.vacation;

import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.domain.vacation.Vacation;
import com.example.inflearn_warmingup_project.dto.vacation.request.CreateAnnualDay;
import com.example.inflearn_warmingup_project.dto.vacation.response.UserRemainAnnualDayResultDto;
import com.example.inflearn_warmingup_project.repository.user.UserRepository;
import com.example.inflearn_warmingup_project.repository.vacation.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VacationService {

    private final VacationRepository vacationRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createAnnualDay(Long id, CreateAnnualDay requestDto) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 직원의 ID입니다."));

        vacationRepository.save(new Vacation(requestDto.getWorkStartDay(), requestDto.getAnnualDay(), findUser));
    }

    public List<UserRemainAnnualDayResultDto> getUserRemainAnnualDay(Long id) {
        return vacationRepository.getUserRemainAnnualDay(id).stream()
                .map(vacation -> new UserRemainAnnualDayResultDto(vacation))
                .collect(Collectors.toList());
    }
}
