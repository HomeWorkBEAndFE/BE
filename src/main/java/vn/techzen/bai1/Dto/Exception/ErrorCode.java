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
    EMPLOYEE_NOT_EXISTED(40401, "Student is not existed", HttpStatus.NOT_FOUND);

    Integer code;
    String message;
    HttpStatusCode status;
}
