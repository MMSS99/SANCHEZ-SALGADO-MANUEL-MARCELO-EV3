package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;

import java.util.HashMap;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {
    private HashMap<Integer, Employee> employeeDatabase = new HashMap<Integer, Employee>();

    public Employee createEmployee(String name, Integer ID, Department department, ExperienceLevel experienceLevel, Shift shift){
        Employee employee = new Employee(ID, name, department, experienceLevel, shift);
        if (!employeeDatabase.containsKey(ID)){
            employeeDatabase.put(ID, employee);
            System.out.println("Empleado " + name + " asignado al departamento " + department.getDepartmentName() + '.');
        } else {
            System.out.println("El empleado con " + ID + " ya existe, por lo que el nuevo empleado no se ha validado en la base de datos.");
        }
        return employee;
    }

}
