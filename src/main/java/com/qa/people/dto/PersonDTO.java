package com.qa.people.dto;

public class PersonDTO {

	private Integer id;

	private String fullName;

	private Integer oldNess;

	private String occupation;

	public PersonDTO(Integer id, String fullName, Integer oldNess, String occupation) {
		this.id = id;
		this.fullName = fullName;
		this.oldNess = oldNess;
		this.occupation = occupation;
	}

	public PersonDTO() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
