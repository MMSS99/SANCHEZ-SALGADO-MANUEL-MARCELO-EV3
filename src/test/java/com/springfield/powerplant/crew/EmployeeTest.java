package com.springfield.powerplant.crew;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee = new Employee(800, "Fernando el Tuerto", Department.ADMINISTRATION, ExperienceLevel.EXPERTO, Shift.NIGHT);

    @Test
    void getters() {
        System.out.println(employee);
        assertEquals(800, employee.getID());
        assertEquals("Fernando el Tuerto", employee.getName());
        assertEquals(Department.ADMINISTRATION, employee.getDepartment());
        assertEquals(ExperienceLevel.EXPERTO, employee.getExperienceLevel());
        assertEquals(Shift.NIGHT, employee.getShift());

        employee.setExperienceLevel(ExperienceLevel.INTERMEDIO);
        assertEquals(ExperienceLevel.INTERMEDIO, employee.getExperienceLevel());
    }

    @Test
    void nullId(){
        assertThrowsExactly(IllegalStateException.class, () -> {
            Employee employeefallo = new Employee(null, "ERROR", Department.ADMINISTRATION, ExperienceLevel.EXPERTO, Shift.NIGHT);
        });
    }
}