
package com.travelAgency.Kursovaya.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserSystem {
    private @Id @GeneratedValue Long id;

    private String roles;
    private String fullName;
    private String username;
    private String password;

    public UserSystem() {
    }

    public UserSystem(String roles, String fullName, String login, String password) {
        this.roles = roles;
        this.fullName = fullName;
        this.username = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getRoles() {
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

    public void setRoles(String roles) {
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

