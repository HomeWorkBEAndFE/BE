package vn.techzen.bai1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techzen.bai1.Model.DepartmentModel;

public interface IDepartmentRepository extends JpaRepository<DepartmentModel, Integer> {
}
