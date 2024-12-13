package vn.techzen.bai1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable UUID id) {
        EmployeeModel employee = employeeService.getEmployee(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employee) {
        if (employee == null || employee.getName() == null || employee.getDob() == null || employee.getGender() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeModel updatedEmployee) {
        if (updatedEmployee == null || updatedEmployee.getName() == null || updatedEmployee.getDob() == null || updatedEmployee.getGender() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployeeModel existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee != null) {
            employeeService.updateEmployee(id, updatedEmployee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        EmployeeModel existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee != null) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
