package com.example.inflearn_warmingup_project.dto.team.response;

import com.example.inflearn_warmingup_project.domain.team.Team;
import lombok.Data;

@Data
public class TeamGetResponseDto {

    private String teamName;
    private String manager;
    private Integer memberCount;

    public TeamGetResponseDto(Team team) {
        this.teamName = team.getName();
        this.manager = team.getManager();
        this.memberCount = team.getMemberCount();
    }
}
