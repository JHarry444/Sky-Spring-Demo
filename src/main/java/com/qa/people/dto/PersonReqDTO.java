package com.qa.people.dto;

public class PersonReqDTO {

    private String fullName;

    private Integer oldNess;

    private String occupation;

    private String notNiNumber;

    public PersonReqDTO(String fullName, Integer oldNess, String occupation, String notNiNumber) {
        this.fullName = fullName;
        this.oldNess = oldNess;
        this.occupation = occupation;
        this.notNiNumber = notNiNumber;
    }

    public PersonReqDTO() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getOldNess() {
        return oldNess;
    }

    public void setOldNess(Integer oldNess) {
        this.oldNess = oldNess;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNotNiNumber() {
        return notNiNumber;
    }

    public void setNotNiNumber(String notNiNumber) {
        this.notNiNumber = notNiNumber;
    }
}
