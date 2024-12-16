package vn.techzen.bai1.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    EmployeeModel getEmployee(UUID id);

    void addEmployee(EmployeeModel employee);

    void updateEmployee(UUID id, EmployeeModel updatedEmployee);

    void deleteEmployee(UUID id);

    List<EmployeeResponse> getFilteredEmployees(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, String salaryRange, String phone, Integer departmentId);
}
