package com.desicabana.stalls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desicabana.stalls.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
