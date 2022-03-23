package practice.adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.application.TestService;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public ResponseEntity<Response> get() {
        testService.throwException();
        return ResponseEntity.ok(new Response("ok"));
    }

    @Getter
    @Setter
    public static class Response {

        private String okMessage;

        private Response() {
        }

        public Response(String okMessage) {
            this.okMessage = okMessage;
        }
    }
}
