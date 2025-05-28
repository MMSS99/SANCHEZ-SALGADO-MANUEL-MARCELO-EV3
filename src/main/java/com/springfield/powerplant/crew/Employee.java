package com.springfield.powerplant.crew;

import java.util.Optional;

public class Employee {
    private final Integer ID;
    private String name;
    private Department department;
    private ExperienceLevel experienceLevel;
    private Shift shift;

    public Employee(Integer ID, String name, Department department, ExperienceLevel experienceLevel, Shift shift){
        this.ID = ID;
        if (ID != null){
            this.name = name;
            this.department = department;
            this.experienceLevel = experienceLevel;
            this.shift = shift;
        } else {
            System.out.println("ERROR EN CREACIÓN: La ID del empleado no puede ser nula");
        }
    }

    public Integer getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public Department getDepartment(){
        return department;
    }

    public ExperienceLevel getExperienceLevel(){
        return experienceLevel;
    }

    public Shift getShift(){
        return shift;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel){
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " (ID: " + getID() + ", Experiencia: " + getExperienceLevel() + ", Turno: " + getShift() + ")");
        return sb.toString();
    }

}
