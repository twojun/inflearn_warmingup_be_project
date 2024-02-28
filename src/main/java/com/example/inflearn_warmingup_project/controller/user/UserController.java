package com.example.inflearn_warmingup_project.controller.user;

import com.example.inflearn_warmingup_project.dto.user.request.UserCreateRequestDto;
import com.example.inflearn_warmingup_project.dto.user.response.UserGetResponseDto;
import com.example.inflearn_warmingup_project.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public void createUser(@RequestBody UserCreateRequestDto request) {
        userService.createUser(request);
    }

    @GetMapping("/api/user/list")
    public List<UserGetResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

}
