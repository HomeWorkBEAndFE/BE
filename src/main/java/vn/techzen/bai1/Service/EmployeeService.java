package vn.techzen.bai1.Service;

import org.springframework.stereotype.Service;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private List<EmployeeModel> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new EmployeeModel(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1990, 1, 15), Gender.Male, 15000000, "0123456789"));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Trần Thị Hòa", LocalDate.of(1992, 3, 22), Gender.Female, 12000000, "0987654321"));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of(1985, 6, 10), Gender.Male, 20000000, "0912345678"));
        employees.add(new EmployeeModel(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of(1995, 8, 30), Gender.Male, 18000000, "0934567890"));
    }

    public List<EmployeeModel> getAllEmployees() {
        return employees;
    }

    public EmployeeModel getEmployee(UUID id) {
        return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
    }

    public void addEmployee(EmployeeModel employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        employees.add(employee);
    }

    public void updateEmployee(UUID id, EmployeeModel updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
    }

    public void deleteEmployee(UUID id) {
        employees = employees.stream()
                .filter(emp -> !emp.getId().equals(id))
                .collect(Collectors.toList());
    }
}