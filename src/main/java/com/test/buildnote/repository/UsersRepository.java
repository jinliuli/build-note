package com.test.buildnote.repository;

import com.test.buildnote.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByLoginId(String loginId);
//
//    Users findByUsername(String username);
}
