package com.springfield.powerplant.crew;

public enum Department {
    REACTOR_CONTROL("Control de Reactor"),
    SECURITY("Seguridad"),
    MAINTENANCE("Mantenimiento"),
    ADMINISTRATION("Administración");

    private final String name;

    Department(String name) {
        this.name = name;
    }


}
