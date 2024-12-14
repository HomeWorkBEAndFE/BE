package vn.techzen.bai1.Repository;

import vn.techzen.bai1.Model.DepartmentModel;

import java.util.List;

public interface IDepartmentRepository {
    DepartmentModel getDepartmentNameById(int id);
    List<DepartmentModel> getAllDepartment();
}
