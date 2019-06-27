package com.example.rathorekaapp.itemFormats;

public class User {
    public String name, email, username, contact;

    public User(String name, String email, String username, String contact) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
