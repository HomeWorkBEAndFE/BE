package vn.techzen.bai1.Service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.bai1.Model.DepartmentModel;
import vn.techzen.bai1.Repository.IDepartmentRepository;
import vn.techzen.bai1.Service.IDepartmentService;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService implements IDepartmentService {
    IDepartmentRepository departmentRepository;

    public List<DepartmentModel> getAllDepartments(){
        return departmentRepository.getAllDepartment();
    }

}
