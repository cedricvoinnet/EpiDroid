package com.example.jordan.epiandroid.Model.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserProfile {
    private String error = null;

    private String login;
    @SerializedName("title")
    @Expose
    private String fullName;

    private String picture;

    @SerializedName("student_year")
    @Expose
    private String studentYear;

    private String promo;

    private String credits;

    private List<Gpa> gpa;

    @SerializedName("internal_email")
    @Expose
    private String email;

    @SerializedName("nsstat")
    @Expose
    private NetSoulStat netStat;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public List<Gpa> getGpa() {
        return gpa;
    }

    public void setGpa(List<Gpa> gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NetSoulStat getNetStat() {
        return netStat;
    }

    public void setNetStat(NetSoulStat netStat) {
        this.netStat = netStat;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean hasError() {
        return error != null;
    }
}
