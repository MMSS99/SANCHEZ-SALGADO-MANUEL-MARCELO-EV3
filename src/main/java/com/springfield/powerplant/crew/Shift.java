package com.springfield.powerplant.crew;

public enum Shift {
    MORNING("Mañana"),
    AFTERNOON("Tarde"),
    NIGHT("Noche");

    private final String shift;

    Shift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }
}
