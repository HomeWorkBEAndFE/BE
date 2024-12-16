package vn.techzen.bai1.Service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.bai1.Model.DepartmentModel;
import vn.techzen.bai1.Repository.IDepartmentRepository;
import vn.techzen.bai1.Service.IDepartmentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService implements IDepartmentService {
    IDepartmentRepository departmentRepository;

    @Override
    public List<DepartmentModel> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentModel getDepartmentNameById(int id) {
        Optional<DepartmentModel> department = departmentRepository.findById(id);
        return department.orElse(null);
    }
}
