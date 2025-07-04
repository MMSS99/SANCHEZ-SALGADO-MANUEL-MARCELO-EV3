package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Department;
import com.springfield.powerplant.crew.Employee;
import com.springfield.powerplant.crew.ExperienceLevel;
import com.springfield.powerplant.crew.Shift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void changeEmployeeExperienceLevel(Employee employee, ExperienceLevel experienceLevel){
        employee.setExperienceLevel(experienceLevel);
    }

    @Override
    public Map<String, Long> getExperienceLevelStatistics(){
        HashMap<String, Long> experienceLevelStatistics = new HashMap<String, Long>();
        for (ExperienceLevel experienceLevel : ExperienceLevel.values()) {
            String level = experienceLevel.getLevel();
            Integer count = 0;
            for (Employee employee : employeeDatabase.values()) {
                if (employee.getExperienceLevel().equals(experienceLevel)) {
                    count++;
                }
            }
            experienceLevelStatistics.put(experienceLevel.getLevel(), count.longValue());
        }
        return experienceLevelStatistics;
    }

    @Override
    public boolean isDepartmentFullyCovered(Department department){
        HashMap<Shift, Employee> shiftChecker = new HashMap<Shift, Employee>();
        for (Employee employee : employeeDatabase.values()) {
            if (employee.getDepartment().equals(department)){
                shiftChecker.putIfAbsent(employee.getShift(), employee);
            }
        }
        return (shiftChecker.size() == 3) ? true : false;
    }

}
