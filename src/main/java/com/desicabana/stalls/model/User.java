package com.desicabana.stalls.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String role;

    public User() {
    }

    /*
     * public User(String username, String password, String role) {
     * this.username = username;
     * this.password = "{noop}" + password;
     * this.role = role;
     * }
     */

    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = "{noop}" + password;
        this.role = role;
    }

    /*
     * public User(Long id, String username, String password) {
     * this.id = id;
     * this.username = username;
     * this.password = "{noop}" + password;
     * this.role = "ROLE_USER";
     * }
     * 
     * public User(String username, String password) {
     * this.username = username;
     * this.password = "{noop}" + password;
     * this.role = "ROLE_USER";
     * }
     * 
     * public User(Long id) {
     * this.id = id;
     * }
     * 
     * public User(Long id, String role) {
     * this.id = id;
     * this.role = role;
     * }
     * 
     * public User(String username) {
     * this.username = username;
     * }
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "{noop}" + password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", role=" + role + ", username=" + username + "]";
    }
}
