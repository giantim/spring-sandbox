package practice.adapter.client;

import feign.FeignException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import practice.adapter.FeignExceptionMapper;

@Service
public class CustomFeignClient {

    private final LocalFeignClient localFeignClient;

    public CustomFeignClient(LocalFeignClient localFeignClient) {
        this.localFeignClient = localFeignClient;
    }

    public void doTest() {
        try {
            localFeignClient.test();
        } catch (FeignException e) {
            throw FeignExceptionMapper.map(CustomFeignClient.class, e);
        }
    }

    @FeignClient(value = "localFeignClient", url = "${feign.client.config.routerFeignClient.url}")
    interface LocalFeignClient {

        @GetMapping("/test")
        Response test();
    }

    @Getter
    @Setter
    public static class Response {

        private String okMessage;

        private Response() {
        }
    }
}
