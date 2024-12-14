package vn.techzen.bai1.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.bai1.Dto.ApiResponse;
import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Dto.Exception.AppException;
import vn.techzen.bai1.Dto.Exception.ErrorCode;
import vn.techzen.bai1.Dto.JsonResponse;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;
import vn.techzen.bai1.Service.IEmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/employees")
public class EmployeeController {

    IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return JsonResponse.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeModel>> getEmployee(@PathVariable UUID id) {
        EmployeeModel employee = employeeService.getEmployee(id);
        if (employee != null) {
            return JsonResponse.ok(employee);
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED);
        }
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeModel employee) {
        if (employee == null || employee.getName() == null || employee.getDob() == null || employee.getGender() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.addEmployee(employee);
        return JsonResponse.created(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeModel updatedEmployee) {
        if (updatedEmployee == null || updatedEmployee.getName() == null || updatedEmployee.getDob() == null || updatedEmployee.getGender() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployeeModel existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee != null) {
            employeeService.updateEmployee(id, updatedEmployee);
            return JsonResponse.ok(updatedEmployee);
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        try {
            EmployeeModel existingEmployee = employeeService.getEmployee(id);
            if (existingEmployee != null) {
                employeeService.deleteEmployee(id);
                return JsonResponse.noContent();
            } else {
                throw new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED);
            }
        } catch (IllegalArgumentException e) {
            throw new AppException(ErrorCode.INVALID_UUID_FORMAT);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "dobFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
            @RequestParam(value = "dobTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
            @RequestParam(value = "gender", required = false) Gender gender,
            @RequestParam(value = "salaryRange", required = false) String salaryRange,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "departmentId", required = false) Integer departmentId) {

        List<EmployeeResponse> filteredEmployees = employeeService.getFilteredEmployees(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
        return JsonResponse.ok(filteredEmployees);
    }
}
