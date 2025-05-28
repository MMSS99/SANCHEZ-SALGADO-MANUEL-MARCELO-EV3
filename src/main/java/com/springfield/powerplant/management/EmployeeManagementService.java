package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;

import java.util.List;
import java.util.Map;

public interface EmployeeManagementService {
    Employee createEmployee(String name, Integer ID, Department department, ExperienceLevel experienceLevel, Shift shift);
    int crewSize();
    void listCrew();
    List<Employee> findEmployeesByDepartment(Department department);
    void changeEmployeeExperienceLevel(Employee employee, ExperienceLevel experienceLevel);
    Map<String, Long> getExperienceLevelStatistics();
}

