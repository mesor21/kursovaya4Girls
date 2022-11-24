package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    private @Id @GeneratedValue Long id;
    private String role;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<UserSystem>  userSystems;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(String role, Set<UserSystem> userSystems) {
        this.role = role;
        this.userSystems = userSystems;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserSystems(Set<UserSystem> userSystems) {
        this.userSystems = userSystems;
    }

    public String getRole() {
        return role;
    }

    public Set<UserSystem> getUserSystems() {
        return userSystems;
    }
}

