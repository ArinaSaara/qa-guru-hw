package com.demoqa.enums;

public enum Subject {
    MATHS("Maths"),
    PHYSICS("Physics"),
    ENGLISH("English"),
    CHEMISTRY("Chemistry"),
    ECONOMICS("Economics"),
    CIVICS("Civics");

    private final String subject;

    Subject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
