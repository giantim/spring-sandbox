package practice.adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity<ErrorResponse> badRequest(RuntimeException exception) {
        ErrorResponse response = new ErrorResponse(
                "bad request message",
                "400",
                "bad request"
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Getter
    @Setter
    public static class ErrorResponse {

        private String message;
        private String code;
        private String type;

        private ErrorResponse() {
        }

        public ErrorResponse(String message, String code, String type) {
            this.message = message;
            this.code = code;
            this.type = type;
        }
    }
}
