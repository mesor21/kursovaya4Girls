package com.travelAgency.Kursovaya.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class UserSystem {
    private @Id @GeneratedValue Long id;
    @ManyToMany(mappedBy = "userSystem")
    private Set<Role> roles;
    private String fullName;
    private String login;
    private String password;


    public Long getId() {
        return id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
