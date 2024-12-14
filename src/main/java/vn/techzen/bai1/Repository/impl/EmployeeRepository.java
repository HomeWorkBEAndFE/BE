package vn.techzen.bai1.Repository.impl;

import org.springframework.stereotype.Repository;
import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;
import vn.techzen.bai1.Repository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

     List<EmployeeModel> employees = new ArrayList<>();
     DepartmentRepository departmentRepository = new DepartmentRepository();

    public EmployeeRepository() {
        employees.add(new EmployeeModel(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1990, 1, 15), Gender.Male, 15000000, "0123456789",1));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Trần Thị Hòa", LocalDate.of(1992, 3, 22), Gender.Female, 12000000, "0987654321",2));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of(1985, 6, 10), Gender.Male, 20000000, "0912345678",3));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of(1995, 8, 30), Gender.Male, 18000000, "0934567890",4));
    }
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employees.stream()
                .map(emp -> new EmployeeResponse(
                        getEmployee(emp.getId()),
                        departmentRepository.getDepartmentNameById(emp.getDepartmentId()) // Lấy tên phòng ban
                ))
                .collect(Collectors.toList());
    }
    @Override
    public List<EmployeeModel> getAll() {
        return employees;
    }

    @Override
    public EmployeeModel getEmployee(UUID id) {
        return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addEmployee(EmployeeModel employee) {
        employees.add(employee);
    }

    @Override
    public void updateEmployee(UUID id, EmployeeModel updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
    }

    @Override
    public void deleteEmployee(UUID id) {
        employees = employees.stream()
                .filter(emp -> !emp.getId().equals(id))
                .collect(Collectors.toList());
    }
}
