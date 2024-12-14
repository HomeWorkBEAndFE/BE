package vn.techzen.bai1.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeModel {
     UUID id;
     String name;
     LocalDate dob;
     Gender gender;
     double salary;
     String phone;
     Integer departmentId;
}