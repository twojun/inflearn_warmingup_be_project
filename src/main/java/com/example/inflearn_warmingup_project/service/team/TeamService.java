package com.example.inflearn_warmingup_project.service.team;

import com.example.inflearn_warmingup_project.domain.team.Team;
import com.example.inflearn_warmingup_project.dto.team.request.TeamCreateRequestDto;
import com.example.inflearn_warmingup_project.dto.team.response.TeamGetResponseDto;
import com.example.inflearn_warmingup_project.repository.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void createTeam(TeamCreateRequestDto request) {
        teamRepository.save(new Team(request.getTeamName()));
    }

    public List<TeamGetResponseDto> getAllTeam() {
        return teamRepository.findAll().stream()
                .map(TeamGetResponseDto::new)
                .collect(Collectors.toList());
    }
}
