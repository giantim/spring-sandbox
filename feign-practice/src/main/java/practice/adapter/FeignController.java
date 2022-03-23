package practice.adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.adapter.client.CustomFeignClient;

@RestController
public class FeignController {

    private final CustomFeignClient customFeignClient;

    public FeignController(CustomFeignClient customFeignClient) {
        this.customFeignClient = customFeignClient;
    }

    @GetMapping("/feign")
    public ResponseEntity<Void> feign() {
        customFeignClient.doTest();

        return ResponseEntity.ok().build();
    }
}
