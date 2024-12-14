package vn.techzen.bai1.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.bai1.Model.DepartmentModel;
import vn.techzen.bai1.Model.EmployeeModel;
import vn.techzen.bai1.Model.Gender;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
     EmployeeModel employee;
     DepartmentModel department;
}
