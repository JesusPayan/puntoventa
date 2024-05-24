package com.puntoventa.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "Role")
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

    @Column(name = "Password",nullable = false,length = 10)
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

}
