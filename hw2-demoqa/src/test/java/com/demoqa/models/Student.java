package com.demoqa.models;

import java.time.LocalDate;

public class Student {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final String mobileNumber;
    private final LocalDate dateOfBirthday;
    private final String subject;
    private final String hobby;
    private final String imageName;
    private final String address;
    private final String state;
    private final String city;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImage(String path) {
        return path + imageName;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getLocation() {
        return state + " " + city;
    }

    public int getDay() {
        return dateOfBirthday.getDayOfMonth();
    }

    public int getMonthAsNumber() {
        return dateOfBirthday.getMonth().getValue();
    }

    public int getYear() {
        return dateOfBirthday.getYear();
    }

    public String getDateOfBirthday() {
        String month = dateOfBirthday.getMonth().name();
        return getDay() + " " + month.substring(0, 1) + month.substring(1).toLowerCase() + "," + getYear();
    }

    public String getAddress() {
        return address;
    }

    public Student(String firstName, String lastName, String email, String gender, String mobileNumber, LocalDate dateOfBirthday, String subject, String hobby, String image, String address, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirthday = dateOfBirthday;
        this.subject = subject;
        this.hobby = hobby;
        this.imageName = image;
        this.address = address;
        this.state = state;
        this.city = city;
    }
}
