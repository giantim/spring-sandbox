package practice.kafka.adapter;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/normal")
    public void normal() {
        kafkaTemplate.send("local-ot-gateway-eventstore", "normal");
    }

    @GetMapping("/error")
    public void error() {
        kafkaTemplate.send("local-ot-gateway-eventstore", "error");
    }

    @GetMapping("/npe")
    public void npe() {
        kafkaTemplate.send("local-ot-gateway-eventstore", "npe");
    }
}
