package com.self.learn.domain;

import java.io.Serializable;

public class Agent {
//public class Agent implements Serializable{
//    private static final long serialVersionUID = 2170158353173178180L;

    private Integer agentId;
    private String userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String timeZone;
    private String workDays;
    private String workDays2;
    private String workStartTime;
    private String workStartTime2;
    private String workEndTime;
    private String workEndTime2;
    private String videoUrl;
    private String profileUrl;
    private String licenseNumber;
    private String licensedSinceYear;
    private String languages;
    private String agentBio;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public String getWorkDays2() {
        return workDays2;
    }

    public void setWorkDays2(String workDays2) {
        this.workDays2 = workDays2;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkStartTime2() {
        return workStartTime2;
    }

    public void setWorkStartTime2(String workStartTime2) {
        this.workStartTime2 = workStartTime2;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getWorkEndTime2() {
        return workEndTime2;
    }

    public void setWorkEndTime2(String workEndTime2) {
        this.workEndTime2 = workEndTime2;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicensedSinceYear() {
        return licensedSinceYear;
    }

    public void setLicensedSinceYear(String licensedSinceYear) {
        this.licensedSinceYear = licensedSinceYear;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getAgentBio() {
        return agentBio;
    }

    public void setAgentBio(String agentBio) {
        this.agentBio = agentBio;
    }
}

