package com.kh.vira_dev.userservice.repository;

import com.kh.vira_dev.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
