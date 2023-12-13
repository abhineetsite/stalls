package com.desicabana.stalls.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long app_user_id;
    private Long role_id;

    public UserRole() {
    }

    public UserRole(Long app_user_id, Long role_id) {
        this.app_user_id = app_user_id;
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(Long app_user_id) {
        this.app_user_id = app_user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}

