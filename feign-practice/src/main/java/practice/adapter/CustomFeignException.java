package practice.adapter;

import lombok.Getter;

@Getter
public class CustomFeignException extends AdminRestClientException {

    public CustomFeignException(int rawHttpStatusCode, String message, Throwable throwable) {
        super(rawHttpStatusCode, message, throwable);
    }
}
