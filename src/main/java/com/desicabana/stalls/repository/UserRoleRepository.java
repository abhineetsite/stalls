package com.desicabana.stalls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desicabana.stalls.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{    
}
