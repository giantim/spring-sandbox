package practice.application;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void throwException() {
        throw new IllegalArgumentException();
    }
}
