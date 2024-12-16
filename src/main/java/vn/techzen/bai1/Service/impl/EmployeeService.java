package vn.techzen.bai1.Service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;
import vn.techzen.bai1.Repository.IEmployeeRepository;
import vn.techzen.bai1.Service.IEmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAllWithDepartment();
    }

    @Override
    public EmployeeModel getEmployee(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void addEmployee(EmployeeModel employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(UUID id, EmployeeModel updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id);
            employeeRepository.save(updatedEmployee);
        }
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public List<EmployeeResponse> getFilteredEmployees(
            String name, LocalDate dobFrom, LocalDate dobTo, Gender gender,
            String salaryRange, String phone, Integer departmentId) {
        return employeeRepository.getFilteredEmployees(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
    }
}
