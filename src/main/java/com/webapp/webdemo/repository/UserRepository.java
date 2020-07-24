package com.webapp.webdemo.repository;

import com.webapp.webdemo.entities.security.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
