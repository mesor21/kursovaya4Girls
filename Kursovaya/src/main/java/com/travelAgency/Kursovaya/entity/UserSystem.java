
package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
public class UserSystem {
    private @Id @GeneratedValue Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role roles;
    private String fullName;
    private String username;
    private String password;

    public UserSystem() {
    }

    public UserSystem(Role roles, String fullName, String login, String password) {
        this.roles = roles;
        this.fullName = fullName;
        this.username = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Role getRoles() {
        return roles;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.username = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

