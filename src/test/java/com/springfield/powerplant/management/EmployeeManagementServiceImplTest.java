package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagementServiceImplTest {
    EmployeeManagementServiceImpl employeeManagementService = new EmployeeManagementServiceImpl();

    @BeforeEach
    void setUp() {
        Employee employee = employeeManagementService.createEmployee("Fernando el Tuerto", 1, Department.SECURITY, ExperienceLevel.NOVATO, Shift.NIGHT);
    }

    @Test
    void newEmployeeState() {
        Employee employee = employeeManagementService.createEmployee("Fernando el Tuerto", 1, Department.SECURITY, ExperienceLevel.INTERMEDIO, Shift.NIGHT);
        assertEquals("Fernando el Tuerto", employee.getName());

        employeeManagementService.changeEmployeeExperienceLevel(employee, ExperienceLevel.INTERMEDIO);
        assertEquals(ExperienceLevel.INTERMEDIO, employee.getExperienceLevel());

        Map<String, Long> experiences = employeeManagementService.getExperienceLevelStatistics();


    }

    @Test
    void crewState(){
        assertEquals(1, employeeManagementService.crewSize());
        assertNull(employeeManagementService.findEmployeesByDepartment(Department.ADMINISTRATION));
        assertNotNull(employeeManagementService.findEmployeesByDepartment(Department.SECURITY));
    }

    @Test
    void statistics(){
        Map<String, Long> experiences = employeeManagementService.getExperienceLevelStatistics();
        assertEquals(3, experiences.size());
        assertEquals(1, experiences.get(ExperienceLevel.NOVATO.getLevel()));

        assertFalse(employeeManagementService.isDepartmentFullyCovered(Department.SECURITY));
    }
}