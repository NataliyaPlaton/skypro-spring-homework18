package pro.sky.skyprospringhomework18.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework18.EmployeeService;
import pro.sky.skyprospringhomework18.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = List.of(
            new Employee("Иван", "Иванов", 50_000, 5),
            new Employee("Петр", "Петров", 60_000, 1),
            new Employee("Сидор", "Сидоров", 100_000, 2),
            new Employee("Борис", "Борисов", 110_000, 1),
            new Employee("Василий", "Васильев", 80_000, 3),
            new Employee("Глеб", "Глебов", 90_000, 4),
            new Employee("Дмитрий", "Дмитриев", 105_000, 3),
            new Employee("Егор", "Егоров", 115_000, 4),
            new Employee("Захар", "Захаров", 75_000, 5),
            new Employee("Кирилл", "Кириллов", 85_000, 1)
    );

    public List<Employee> getEmployees() {
        final List<Employee> employees1 = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
        return employees1;
    }

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeeWithMinSalary(int departmentId) {
        return Collections.singletonList(employees.stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .get());
    }

    public List<Employee> findEmployeeWithMaxSalary(int departmentId) {
        return Collections.singletonList(employees.stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .get());
    }
}

