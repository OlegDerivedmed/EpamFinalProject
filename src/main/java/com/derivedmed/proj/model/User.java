package com.derivedmed.proj.model;

import com.derivedmed.proj.util.annotations.Column;
import com.derivedmed.proj.util.annotations.Model;

@Model
public class User {

    @Column(name = "user_id")
    private int id;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(int id, int role_id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
