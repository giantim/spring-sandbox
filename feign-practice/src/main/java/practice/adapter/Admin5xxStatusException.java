package practice.adapter;

import lombok.Getter;

@Getter
public class Admin5xxStatusException extends AdminRestClientException {

    public Admin5xxStatusException(int status, String s, Throwable e) {
        super(status, s, e);
    }
}
