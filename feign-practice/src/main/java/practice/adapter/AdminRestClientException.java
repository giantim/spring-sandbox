package practice.adapter;

import lombok.Getter;

@Getter
public class AdminRestClientException extends RuntimeException {

    protected int rawHttpStatusCode;
    protected String message;
    protected Throwable throwable;

    public AdminRestClientException(int rawHttpStatusCode, String message, Throwable cause) {
        this.message = message;
        this.throwable = cause;
        this.rawHttpStatusCode = rawHttpStatusCode;
    }
}
