package vn.techzen.bai1.Dto.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.techzen.bai1.Dto.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse> handleAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        ApiResponse response = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleInvalidUUID(IllegalArgumentException exception) {
        ApiResponse response = ApiResponse.builder()
                .code(ErrorCode.INVALID_UUID_FORMAT.getCode())
                .message(ErrorCode.INVALID_UUID_FORMAT.getMessage())
                .build();

        return ResponseEntity.status(ErrorCode.INVALID_UUID_FORMAT.getStatus()).body(response);
    }
}
