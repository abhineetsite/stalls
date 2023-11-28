package com.desicabana.stalls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desicabana.stalls.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
