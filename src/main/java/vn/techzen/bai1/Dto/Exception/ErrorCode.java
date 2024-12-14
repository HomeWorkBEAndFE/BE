package vn.techzen.bai1.Dto.Exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.net.http.HttpClient;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    EMPLOYEE_NOT_EXISTED(40401, "Employee is not existed", HttpStatus.NOT_FOUND),
    DEPARTMENT_NOT_EXISTED(40402, "Department is not existed", HttpStatus.NOT_FOUND),
    INVALID_UUID_FORMAT(40001, "Invalid UUID format", HttpStatus.BAD_REQUEST);

    Integer code;
    String message;
    HttpStatusCode status;
}
