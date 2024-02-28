package com.example.inflearn_warmingup_project.controller.team;

import com.example.inflearn_warmingup_project.dto.team.request.TeamCreateRequestDto;
import com.example.inflearn_warmingup_project.dto.team.response.TeamGetResponseDto;
import com.example.inflearn_warmingup_project.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/api/team")
    public void createTeam(@RequestBody TeamCreateRequestDto request) {
        teamService.createTeam(request);
    }

    @GetMapping("/api/team/list")
    public List<TeamGetResponseDto> getAllTeam() {
        return teamService.getAllTeam();
    }
}
