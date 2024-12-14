package vn.techzen.bai1.Repository;

import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.EmployeeModel;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {
    List<EmployeeResponse> getAllEmployees();
    EmployeeModel getEmployee(UUID id) ;
    void addEmployee(EmployeeModel employee);
    void updateEmployee(UUID id, EmployeeModel updatedEmployee);
    void deleteEmployee(UUID id);
    List<EmployeeModel> getAll();
}
