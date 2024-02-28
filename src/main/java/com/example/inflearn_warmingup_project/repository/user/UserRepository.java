package com.example.inflearn_warmingup_project.repository.user;

import com.example.inflearn_warmingup_project.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
