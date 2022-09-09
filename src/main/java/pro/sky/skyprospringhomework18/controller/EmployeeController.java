package pro.sky.skyprospringhomework18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringhomework18.EmployeeService;
import pro.sky.skyprospringhomework18.model.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> allEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/min-salary")
    public List<Employee> employeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public List<Employee> employeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeesByDepartmentId(@RequestParam("departmentId") int departmentId) {
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }
}
