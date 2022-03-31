package practice.kafka.adapter;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import practice.kafka.KafkaConsumerConfig;

@Component
public class KafkaTestListener {

    private final KafkaMessageHandler kafkaMessageHandler;

    public KafkaTestListener(KafkaMessageHandler kafkaMessageHandler) {
        this.kafkaMessageHandler = kafkaMessageHandler;
    }

    @KafkaListener(
            topics = "local-ot-gateway-eventstore",
            groupId = "kafka-practice",
            containerFactory = KafkaConsumerConfig.CONTAINER_FACTORY
    )
    public void handle(Message<String> message, Acknowledgment acknowledgment) {
        String payload = message.getPayload();

        try {
            if (payload.equals("normal")) {
                System.out.println("this is normal");
                kafkaMessageHandler.illegalArgument();
            } else if (payload.equals("error")) {
                System.out.println("this is error");
                kafkaMessageHandler.illegalState();
            } else if (payload.equals("npe")) {
                System.out.println("this is npe");
                kafkaMessageHandler.npe();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("illegal argument exception catch");
        }
        acknowledgment.acknowledge();
    }
}
