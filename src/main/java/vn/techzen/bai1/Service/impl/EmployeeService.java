package vn.techzen.bai1.Service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Respository.IEmployeeRepository;
import vn.techzen.bai1.Service.IEmployeeService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;


    @Override
    public List<EmployeeModel> getAllEmployees() {
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
}
