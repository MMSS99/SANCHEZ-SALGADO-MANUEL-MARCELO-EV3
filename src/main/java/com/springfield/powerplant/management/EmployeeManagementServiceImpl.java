package com.springfield.powerplant.management;

import com.springfield.powerplant.crew.Employee;

import java.util.HashMap;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {
    private HashMap<Integer, Employee> employeeDatabase = new HashMap<Integer, Employee>();

    public void createEmployee(){
        Employee employee = new Employee();
    }

}
