package com.operatingSystem.model;

import java.sql.Timestamp;

public class User {
    private int id;
    private String name;
    private String password;
    private Timestamp createDate;
    private Timestamp updateDate;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String toString() {
        return "User{id=" + this.id + ", name='" + this.name + '\'' + ", password='" + this.password + '\'' + ", createDate=" + this.createDate + ", updateDate=" + this.updateDate + '}';
    }

    public User() {
    }
}
