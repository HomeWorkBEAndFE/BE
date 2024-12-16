package vn.techzen.bai1.Service;

import vn.techzen.bai1.Dto.EmployeeResponse;
import vn.techzen.bai1.Model.DepartmentModel;

import java.util.List;

public interface IDepartmentService {
    DepartmentModel getDepartmentNameById(int id);

    List<DepartmentModel> getAllDepartments();
}
