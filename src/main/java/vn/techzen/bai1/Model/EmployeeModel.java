package vn.techzen.bai1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class EmployeeModel {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     UUID id;

     String name;
     LocalDate dob;
     Gender gender;
     double salary;
     String phone;
     @ManyToOne
     @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
     @JsonBackReference
     DepartmentModel department;

     @Column(name = "department_id")
     Integer departmentId;
}
