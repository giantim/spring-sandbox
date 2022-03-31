package practice.kafka.adapter;

import org.springframework.stereotype.Component;

@Component
public class KafkaMessageHandler {

    public void illegalState() {
        throw new IllegalStateException();
    }

    public void npe() {
        throw new NullPointerException();
    }

    public void illegalArgument() {
        throw new IllegalArgumentException();
    }
}
