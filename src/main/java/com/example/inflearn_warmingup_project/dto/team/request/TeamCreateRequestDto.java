package com.example.inflearn_warmingup_project.dto.team.request;

import lombok.Data;

@Data
public class TeamCreateRequestDto {

    private String teamName;

    public void checkValidationTeamName() {
        if (this.teamName.isEmpty()) {
            throw new IllegalStateException("유효한 팀 이름을 입력해 주세요.");
        }
    }
}
