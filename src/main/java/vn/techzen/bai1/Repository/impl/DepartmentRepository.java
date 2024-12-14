package vn.techzen.bai1.Repository.impl;

import org.springframework.stereotype.Repository;
import vn.techzen.bai1.Model.DepartmentModel;
import vn.techzen.bai1.Repository.IDepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
    private List<DepartmentModel> department = new ArrayList<>();

    public DepartmentRepository() {
        department.add(new DepartmentModel(1,"Quản lý"));
        department.add(new DepartmentModel(2,"Kế toán"));
        department.add(new DepartmentModel(3,"Sale-Marketing"));
        department.add(new DepartmentModel(4,"Sản xuất"));
    }

    @Override
    public DepartmentModel getDepartmentNameById(int id) {
        return department.stream()
                .filter(dept -> dept.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DepartmentModel> getAllDepartment() {
        return department;
    }

}
