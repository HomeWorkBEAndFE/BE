package vn.techzen.bai1.Service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;
import vn.techzen.bai1.Repository.IEmployeeRepository;
import vn.techzen.bai1.Repository.impl.DepartmentRepository;
import vn.techzen.bai1.Service.IEmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository = new DepartmentRepository();


    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public EmployeeModel getEmployee(UUID id) {
        return employeeRepository.getEmployee(id);
    }

    @Override
    public void addEmployee(EmployeeModel employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(UUID id, EmployeeModel updatedEmployee) {
        if (employeeRepository.getEmployee(id) != null) {
            updatedEmployee.setId(id);
            employeeRepository.updateEmployee(id, updatedEmployee);
        }
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteEmployee(id);
    }
    public List<EmployeeResponse> getFilteredEmployees(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId) {
        List<EmployeeModel> employees = employeeRepository.getAll();

        return employees.stream()
                .filter(e -> name == null || e.getName().toLowerCase().contains(name.toLowerCase())) // Filter by name
                .filter(e -> dobFrom == null || !e.getDob().isBefore(dobFrom)) // Filter by dobFrom
                .filter(e -> dobTo == null || !e.getDob().isAfter(dobTo)) // Filter by dobTo
                .filter(e -> gender == null || e.getGender() == gender) // Filter by gender
                .filter(e -> phone == null || e.getPhone().contains(phone)) // Filter by phone
                .filter(e -> departmentId == null || e.getDepartmentId().equals(departmentId)) // Filter by departmentId
                .filter(e -> {
                    if (salaryRange == null) {
                        return true;
                    }
                    switch (salaryRange) {
                        case "lt5":
                            return e.getSalary() < 5000000;
                        case "5-10":
                            return e.getSalary() >= 5000000 && e.getSalary() < 10000000;
                        case "10-20":
                            return e.getSalary() >= 10000000 && e.getSalary() < 20000000;
                        case "gte20":
                            return e.getSalary() >= 20000000;
                        default:
                            return true;
                    }
                })
                .map(e -> new EmployeeResponse(
                        employeeRepository.getEmployee(e.getId()),
                        departmentRepository.getDepartmentNameById(e.getDepartmentId()) ))
                .collect(Collectors.toList());
    }
}
