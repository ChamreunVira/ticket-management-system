package com.kh.vira_dev.userservice.repository;

import com.kh.vira_dev.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
