package com.qa.people.dto;

public class PersonDTO {

    private String fullName;

    private Integer oldNess;

    private String occupation;


    public PersonDTO(String fullName, Integer oldNess, String occupation) {
        this.fullName = fullName;
        this.oldNess = oldNess;
        this.occupation = occupation;
    }

    public PersonDTO() {
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
}
