package practice.adapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.Getter;

import java.io.IOException;
import java.nio.ByteBuffer;

public class FeignExceptionMapper {

    private static final ObjectMapper ERROR_MESSAGE_CONVERTOR;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        ERROR_MESSAGE_CONVERTOR = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private FeignExceptionMapper() {
    }

    public static AdminRestClientException map(Class<?> from, FeignException e) {

        if (is4xxStatus(e.status())) {
            String message = e.responseBody()
                    .map(FeignExceptionMapper::errorMessage)
                    .orElse("");
            return new CustomFeignException(e.status(), message, e);
        }

        if (is5xxStatus(e.status())) {
            return new Admin5xxStatusException(e.status(), "서버에 응답이 없습니다. 잠시 후 다시 요청해주세요.", e);
        }

        return new AdminRestClientException(e.status(), e.getMessage(), e);
    }

    private static boolean is4xxStatus(int status) {
        return 400 <= status && status < 500;
    }

    private static boolean is5xxStatus(int status) {
        return 500 <= status && status < 600;
    }

    private static String errorMessage(ByteBuffer buffer) {
        try {
            return ERROR_MESSAGE_CONVERTOR.readValue(buffer.array(), ErrorMessage.class).getMessage();
        } catch (IOException e) {
            return "";
        }
    }

    @Getter
    private static class ErrorMessage {

        private String message;
    }
}
