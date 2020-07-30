package com.webapp.webdemo.repository;

import com.webapp.webdemo.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
