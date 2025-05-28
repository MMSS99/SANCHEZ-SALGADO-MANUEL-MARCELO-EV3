package com.springfield.powerplant.crew;

public enum ExperienceLevel {
    NOVATO("Novato"),
    INTERMEDIO("Intermedio"),
    EXPERTO("Experto");

    private final String level;

    ExperienceLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }


}
