package com.sutrix.demo.core.bean;


import javax.jcr.RepositoryException;
import javax.jcr.Value;

public class SignupUser {

    private String userid;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String reenterpswd;

    private  String email;

    private String mobileno;

    public SignupUser() {
    }

    public SignupUser(String userid,String firstname, String lastname, String username, String password, String reenterpswd, String email, String mobileno) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.reenterpswd = reenterpswd;
        this.email = email;
        this.mobileno = mobileno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReenterpswd() {
        return reenterpswd;
    }

    public void setReenterpswd(String reenterpswd) {
        this.reenterpswd = reenterpswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

}
