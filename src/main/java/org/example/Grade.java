package org.example;

enum Grade {
    A_PLUS("A+"),
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    F("F"),
    Nil("Not Set");
    private final String description;

    Grade(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
