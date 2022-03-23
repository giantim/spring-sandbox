package practice.adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            CustomFeignException.class
    })
    public ResponseEntity<ErrorResponse> error(AdminRestClientException exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());

        return ResponseEntity.status(exception.getRawHttpStatusCode())
                .body(response);
    }

    @Getter
    @Setter
    public static class ErrorResponse {

        private String message;

        private ErrorResponse() {
        }

        public ErrorResponse(String message) {
            this.message = message;
        }
    }
}
