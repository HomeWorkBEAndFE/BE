package vn.techzen.bai1.Service;

import vn.techzen.bai1.Model.EmployeeModel;

import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
    List<EmployeeModel> getAllEmployees();
    EmployeeModel getEmployee(UUID id);
    void addEmployee(EmployeeModel employee);
    void updateEmployee(UUID id, EmployeeModel updatedEmployee);
    void deleteEmployee(UUID id);
}
