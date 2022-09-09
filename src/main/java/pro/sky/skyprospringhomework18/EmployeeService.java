package pro.sky.skyprospringhomework18;

import pro.sky.skyprospringhomework18.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    List<Employee> findEmployeeWithMinSalary(int departmentId);

    List<Employee> findEmployeeWithMaxSalary(int departmentId);

    List<Employee> getEmployeesByDepartmentId(int departmentId);


}
