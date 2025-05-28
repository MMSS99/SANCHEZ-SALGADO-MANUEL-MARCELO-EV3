package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public int crewSize(){
        return employeeDatabase.size();
    }

    @Override
    public void listCrew(){
        employeeDatabase.forEach((id, employee) -> {
            System.out.println(employee.toString());
        });
    }

    @Override
    public List<Employee> findEmployeesByDepartment(Department department){
        List<Employee> employees = new ArrayList<Employee>();
        employeeDatabase.forEach((id, employee) -> {
            if (employee.getDepartment().equals(department)){
                employees.add(employee);
            }
        });
        return employees.isEmpty() ? null : employees;
    }

}
