package com.qa.people.entities;

import javax.validation.constraints.*;

public class Person {

    @Size(min = 2, max = 50)
    private String name;

    @Min(0)
    @Max(100)
    private int age;


    @NotNull // -> null
//    @NotEmpty -> ""
//    @NotBlank -> "   "
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    // REQUIRED
    public Person() {
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
