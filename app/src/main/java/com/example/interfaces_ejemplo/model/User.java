package com.example.interfaces_ejemplo.model;

public class User {
    public String name;
    public String email;
    public String password;
    public String image;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "";
        this.image = "";
    }

    public User(String name, String email, String password, String image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
    }
}
