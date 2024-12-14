package vn.techzen.bai1.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.bai1.Dto.JsonResponse;
import vn.techzen.bai1.Model.DepartmentModel;
import vn.techzen.bai1.Service.IDepartmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/department")

public class DepartmentController {
    IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartment() {
        List<DepartmentModel> departments = departmentService.getAllDepartments();
        return JsonResponse.ok(departments);
    }
}
