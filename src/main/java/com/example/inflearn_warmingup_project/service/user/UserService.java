package com.example.inflearn_warmingup_project.service.user;

import com.example.inflearn_warmingup_project.domain.team.Team;
import com.example.inflearn_warmingup_project.domain.user.User;
import com.example.inflearn_warmingup_project.dto.user.request.UserCreateRequestDto;
import com.example.inflearn_warmingup_project.dto.user.response.UserGetResponseDto;
import com.example.inflearn_warmingup_project.repository.team.TeamRepository;
import com.example.inflearn_warmingup_project.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void createUser(UserCreateRequestDto requestDto) {
        requestDto.isValidValue();

        Team findTeam = teamRepository.findByName(requestDto.getTeamName())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 팀입니다."));

        userRepository.save(new User(requestDto, findTeam));
    }

    public List<UserGetResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserGetResponseDto::new)
                .collect(Collectors.toList());
    }
}
