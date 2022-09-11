package pro.sky.skyprospringhomework18.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework18.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhomework18.exception.EmployeeNotFoundException;
import pro.sky.skyprospringhomework18.exception.EmployeeStorageIsFullException;
import pro.sky.skyprospringhomework18.model.Employee;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String lastName) {
        return firstName + "|" + lastName;
    }

    public Employee addEmployee(String firstName,
                                String lastName,
                                double salary,
                                int department) {
        Employee employee = new Employee(firstName, lastName, (int) salary, department);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName,
                                   String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }


    public Employee findEmployee(String firstName,
                                 String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}

