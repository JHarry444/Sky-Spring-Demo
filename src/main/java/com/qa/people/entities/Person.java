package com.qa.people.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity // flags this class as a DB entity (table)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment
    private Integer id;

    @Size(min = 2, max = 50)
    @Column(nullable = false) // NOT NULL
    private String name;

    @Min(0)
    @Max(100)
    private int age;


    @NotNull // -> null
//    @NotEmpty -> ""
//    @NotBlank -> "   "
    private String job;

    private String niNumber;

    public Person(String name, int age, String job, String niNumber) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.niNumber = niNumber;
    }

    // REQUIRED
    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
