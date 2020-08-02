package com.webapp.webdemo.repository;

import com.webapp.webdemo.constants.enums.RoleName;
import com.webapp.webdemo.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
