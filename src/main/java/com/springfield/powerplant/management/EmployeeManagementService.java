package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;

public interface EmployeeManagementService {
    Employee createEmployee(String name, Integer ID, Department department, ExperienceLevel experienceLevel, Shift shift);
    int crewSize();
}

