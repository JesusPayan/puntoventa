package com.puntoventa.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @Column(name = "ID",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "User_name",length = 80,nullable = false)
    private String userName;

    @Column(name = "User_LastName",length = 80,nullable = false)
    private String UserLastname;

    @Column(name = "UUID",unique = true,nullable = false,length = 20)
    private String userID;

    @Column(name = "Password",nullable = false,length = 200)
    private String password;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "DeleteDate")
    private Date deleteDate;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "Role",nullable = false)
    private String role;

    public Long getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastname() {
        return UserLastname;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public boolean isActive() {
        return active;
    }

    public String getRole() {
        return role;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
