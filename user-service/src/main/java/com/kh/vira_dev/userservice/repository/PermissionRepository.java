package com.kh.vira_dev.userservice.repository;

import com.kh.vira_dev.userservice.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission , Long> {
}
