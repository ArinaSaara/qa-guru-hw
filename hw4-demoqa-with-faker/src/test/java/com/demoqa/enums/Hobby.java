package com.demoqa.enums;

public enum Hobby {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String hobby;

    Hobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}
